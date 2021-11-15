package io.codebyexample.servicea.dataprovider.grpcapi.serviced;

import io.codebyexample.servicea.core.entity.MessageD;
import io.codebyexample.servicea.util.ProtobufUtils;
import io.codebyexample.serviced.proto.v1.DRequest;
import io.codebyexample.serviced.proto.v1.DResponse;
import io.codebyexample.serviced.proto.v1.ServiceDGrpc.ServiceDBlockingStub;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

/** @author huypva */
@Slf4j
@Component
public class ServiceDClient implements ServiceDApi {

  @GrpcClient("serviced")
  private ServiceDBlockingStub serviceDBlockingStub;

  @Override
  public String callMethodD(MessageD messageD) {
    try {
      DRequest request = DRequest.newBuilder()
          .setId(messageD.getId())
          .build();
      final DResponse response = this.serviceDBlockingStub.callMethodD(request);

      return ProtobufUtils.print(response);
    } catch (final StatusRuntimeException e) {
      return "FAILED with " + e.getStatus().getCode().name();
    }
  }
}
