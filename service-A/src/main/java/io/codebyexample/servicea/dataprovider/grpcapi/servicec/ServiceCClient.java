package io.codebyexample.servicea.dataprovider.grpcapi.servicec;

import io.codebyexample.servicea.core.entity.MessageC;
import io.codebyexample.servicea.util.ProtobufUtils;
import io.codebyexample.servicec.proto.v1.CRequest;
import io.codebyexample.servicec.proto.v1.CResponse;
import io.codebyexample.servicec.proto.v1.ServiceCGrpc.ServiceCBlockingStub;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

/** @author sateam */
@Slf4j
@Component
public class ServiceCClient implements ServiceCApi {

  @GrpcClient("servicec")
  private ServiceCBlockingStub serviceCBlockingStub;

  @Override
  public String callMethodC(MessageC messageC) {
    try {
      CRequest request = CRequest.newBuilder()
          .setId(messageC.getId())
          .build();

      final CResponse response = this.serviceCBlockingStub.callMethodC(request);

      return ProtobufUtils.print(response);
    } catch (final StatusRuntimeException e) {
      return "FAILED with " + e.getStatus().getCode().name();
    }
  }
}
