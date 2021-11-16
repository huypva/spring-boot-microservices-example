package io.codebyexample.servicea.dataprovider.grpcapi.serviceb;

import io.codebyexample.servicea.core.entity.MessageB;
import io.codebyexample.servicea.util.ProtobufUtils;
import io.codebyexample.servicea.proto.v1.BRequest;
import io.codebyexample.servicea.proto.v1.BResponse;
import io.codebyexample.servicea.proto.v1.ServiceBGrpc.ServiceBBlockingStub;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 * */
@Slf4j
@Component
public class ServiceBClient implements ServiceBApi {

  @GrpcClient("serviceb")
  private ServiceBBlockingStub serviceBBlockingStub;

  @Override
  public String callMethodB(MessageB bMessage) {
    try {
      BRequest bRequest = BRequest.newBuilder()
          .setId(bMessage.getId())
          .build();
      BResponse response = this.serviceBBlockingStub.callMethodB(bRequest);

      return ProtobufUtils.print(response);
    } catch (final StatusRuntimeException e) {
      return "FAILED with " + e.getStatus().getCode().name();
    }
  }
}
