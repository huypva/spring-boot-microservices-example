package io.codebyexample.servicea.util.common;

import com.google.protobuf.Any;
import com.google.rpc.Code;
import com.google.rpc.ErrorInfo;
import com.google.rpc.Status;
import io.codebyexample.servicea.util.DomainUtils;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import lombok.Getter;
import io.codebyexample.servicea.util.common.enums.ReasonEnum;

import java.util.Map;

/** @author sateam */
@Getter
public class StatusRuntimeExceptionBuilder {

  private Code code = Code.UNKNOWN;
  private String message = "Unknown";
  private String reason = ReasonEnum.EXCEPTION.toString();
  private String domain = DomainUtils.THIS;
  private Map<String, String> metaData = null;

  public static StatusRuntimeExceptionBuilder newUnAuthenticatedBuilder() {
    StatusRuntimeExceptionBuilder builder = new StatusRuntimeExceptionBuilder();
    builder.code = Code.UNAUTHENTICATED;
    builder.message = "Request is not authenticated";
    builder.reason = ReasonEnum.REQUEST_IS_NOT_AUTHENTICATED.toString();
    return builder;
  }

  public static StatusRuntimeExceptionBuilder newInvalidArgumentBuilder() {
    StatusRuntimeExceptionBuilder builder = new StatusRuntimeExceptionBuilder();
    builder.code = Code.INVALID_ARGUMENT;
    builder.reason = ReasonEnum.REQUEST_FORMAT_IS_INVALID.toString();
    return builder;
  }

  public static StatusRuntimeExceptionBuilder newFailedPreConditionBuilder() {
    StatusRuntimeExceptionBuilder builder = new StatusRuntimeExceptionBuilder();
    builder.code = Code.FAILED_PRECONDITION;
    return builder;
  }

  public static StatusRuntimeExceptionBuilder newNotFoundBuilder() {
    StatusRuntimeExceptionBuilder builder = new StatusRuntimeExceptionBuilder();
    builder.code = Code.NOT_FOUND;
    return builder;
  }

  public static StatusRuntimeExceptionBuilder newPermissionDeniedBuilder() {
    StatusRuntimeExceptionBuilder builder = new StatusRuntimeExceptionBuilder();
    builder.code = Code.PERMISSION_DENIED;
    builder.message = "Request is not authorized";
    builder.reason = ReasonEnum.REQUEST_IS_NOT_AUTHORIZED.toString();
    return builder;
  }

  public StatusRuntimeException build() {
    ErrorInfo.Builder errorInfo = ErrorInfo.newBuilder().setReason(reason).setDomain(domain);

    if (metaData != null) {
      errorInfo.putAllMetadata(metaData);
    }

    return StatusProto.toStatusRuntimeException(
        Status.newBuilder()
            .setCode(code.getNumber())
            .setMessage(message)
            .addDetails(Any.pack(errorInfo.build()))
            .build());
  }

  public StatusRuntimeExceptionBuilder setCode(Code code) {
    this.code = code;
    return this;
  }

  public StatusRuntimeExceptionBuilder setMessage(String message) {
    this.message = message;
    return this;
  }

  public StatusRuntimeExceptionBuilder setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public StatusRuntimeExceptionBuilder setDomain(String domain) {
    this.domain = domain;
    return this;
  }

  public StatusRuntimeExceptionBuilder setMetaData(Map<String, String> metaData) {
    this.metaData = metaData;
    return this;
  }
}
