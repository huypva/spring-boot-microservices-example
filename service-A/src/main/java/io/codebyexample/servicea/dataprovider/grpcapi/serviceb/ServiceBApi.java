package io.codebyexample.servicea.dataprovider.grpcapi.serviceb;

import io.codebyexample.servicea.core.entity.MessageB;

/**
 * @author huypva
 * */
public interface ServiceBApi {

  String callMethodB(MessageB bMessage);
}
