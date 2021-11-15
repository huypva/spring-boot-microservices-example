package io.codebyexample.servicea.dataprovider.grpcapi.serviceb;

import io.codebyexample.servicea.core.entity.MessageB;

/** @author sateam */
public interface ServiceBApi {

  String callMethodB(MessageB bMessage);
}
