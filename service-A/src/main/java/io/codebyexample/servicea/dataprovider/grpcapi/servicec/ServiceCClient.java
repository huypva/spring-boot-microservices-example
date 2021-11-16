package io.codebyexample.servicea.dataprovider.grpcapi.servicec;

import io.codebyexample.servicea.core.entity.MessageC;
import io.codebyexample.servicea.proto.v1.GetMessageRequest;
import io.codebyexample.servicea.proto.v1.GetMessageResponse;
import io.codebyexample.servicea.proto.v1.ServiceCGrpc.ServiceCBlockingStub;
import io.codebyexample.servicea.proto.v1.SetMessageRequest;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 * */
@Slf4j
@Component
public class ServiceCClient implements ServiceCApi {

  @GrpcClient("servicec")
  private ServiceCBlockingStub serviceCBlockingStub;

  @Override
  public void setMessage(MessageC messageC) {
    SetMessageRequest request = SetMessageRequest.newBuilder()
        .setId(messageC.getId())
        .setMessage(messageC.getMessage())
        .build();

    this.serviceCBlockingStub.setMessage(request);
  }

  @Override
  public String getMessage(int id) {
    GetMessageRequest request = GetMessageRequest.newBuilder()
        .setId(id)
        .build();

    GetMessageResponse response = this.serviceCBlockingStub.getMessage(request);

    return response.getMessage();
  }
}
