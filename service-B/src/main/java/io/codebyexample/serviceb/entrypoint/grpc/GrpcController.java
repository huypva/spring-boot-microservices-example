package io.codebyexample.serviceb.entrypoint.grpc;

import io.codebyexample.serviceb.core.entity.BMessage;
import io.codebyexample.serviceb.core.usercase.greeter.BUseCase;
import io.codebyexample.serviceb.proto.v1.BRequest;
import io.codebyexample.serviceb.proto.v1.BResponse;
import io.codebyexample.serviceb.proto.v1.ServiceBGrpc;
import io.codebyexample.serviceb.utils.ProtobufUtils;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huypva
 */
@Slf4j
@GrpcService
public class GrpcController extends ServiceBGrpc.ServiceBImplBase {

  @Autowired
  BUseCase bUseCase;

  @Override
  public void callMethodB(BRequest req, StreamObserver<BResponse> responseObserver) {
    log.info("GrpcController.callMethodB start {}" + ProtobufUtils.print(req));
    bUseCase.methodB(req.getId());

    BResponse reply = BResponse.newBuilder()
        .setMessage("ServiceB.callMethodB id=" + req.getId())
        .build();
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
    log.info("GrpcController.callMethodB end {}" + ProtobufUtils.print(req));
  }

}
