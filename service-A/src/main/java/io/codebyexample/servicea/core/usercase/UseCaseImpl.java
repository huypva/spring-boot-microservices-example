package io.codebyexample.servicea.core.usercase;

import io.codebyexample.servicea.core.entity.MessageB;
import io.codebyexample.servicea.core.entity.MessageC;
import io.codebyexample.servicea.core.entity.MessageD;
import io.codebyexample.servicea.dataprovider.grpcapi.servicec.ServiceCApi;
import io.codebyexample.servicea.dataprovider.grpcapi.serviced.ServiceDApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.codebyexample.servicea.dataprovider.grpcapi.serviceb.ServiceBApi;

/** @author sateam */
@Slf4j
@Component
@RequiredArgsConstructor
public class UseCaseImpl implements UseCase {

  @Autowired
  private final ServiceBApi serviceBApi;

  @Autowired
  private final ServiceCApi serviceCApi;

  @Autowired
  private final ServiceDApi serviceDApi;

  @Override
  public String callServiceB(MessageB messageB) {
    return serviceBApi.callMethodB(messageB);
  }

  @Override
  public String callServiceC(MessageC messageC) {
    return serviceCApi.callMethodC(messageC);
  }

  @Override
  public String callServiceD(MessageD messageD) {
    return serviceDApi.callMethodD(messageD);
  }
}
