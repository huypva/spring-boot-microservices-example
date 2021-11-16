package io.codebyexample.servicea.core.usercase;

import io.codebyexample.servicea.core.entity.MessageB;
import io.codebyexample.servicea.core.entity.MessageC;
import io.codebyexample.servicea.core.entity.MessageD;
import io.codebyexample.servicea.dataprovider.grpcapi.servicec.ServiceCApi;
import io.codebyexample.servicea.dataprovider.messaging.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.codebyexample.servicea.dataprovider.grpcapi.serviceb.ServiceBApi;

/**
 * @author huypva
 * */
@Slf4j
@Component
@RequiredArgsConstructor
public class UseCaseImpl implements UseCase {

  @Autowired
  private final ServiceBApi serviceBApi;

  @Autowired
  private final ServiceCApi serviceCApi;

  @Autowired
  KafkaProducer kafkaProducer;

  @Override
  public String callServiceB(MessageB messageB) {
    return serviceBApi.callMethodB(messageB);
  }

  @Override
  public void setMessageC(MessageC messageC) {
    serviceCApi.setMessage(messageC);
  }

  @Override
  public String getMessageC(int id) {
    return serviceCApi.getMessage(id);
  }

  @Override
  public void sendMessageD(MessageD messageD) {
    kafkaProducer.sendMessageD(messageD);
  }
}
