package io.codebyexample.servicec.entrypoint;

import com.google.protobuf.Empty;
import io.codebyexample.servicec.core.entity.MessageC;
import io.codebyexample.servicec.core.usecase.CUseCase;
import io.codebyexample.servicec.proto.v1.GetMessageRequest;
import io.codebyexample.servicec.proto.v1.GetMessageResponse;
import io.codebyexample.servicec.proto.v1.ServiceCGrpc;
import io.codebyexample.servicec.proto.v1.SetMessageRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huypva
 */
@GrpcService
public class GrpcController extends ServiceCGrpc.ServiceCImplBase {

  @Autowired
  CUseCase useCase;

  @Override
  public void setMessage(SetMessageRequest request, StreamObserver<com.google.protobuf.Empty> responseObserver) {

    MessageC messageC = MessageC.builder()
        .id(request.getId())
        .message(request.getMessage())
        .build();

    useCase.setMessageC(messageC);

    responseObserver.onNext(Empty.getDefaultInstance());
    responseObserver.onCompleted();
  }

  @Override
  public void getMessage(GetMessageRequest request, StreamObserver<GetMessageResponse> responseObserver) {
    MessageC messageC = useCase.getMessageC(request.getId());
    GetMessageResponse response = GetMessageResponse.newBuilder()
        .setMessage(messageC.getMessage())
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

}
