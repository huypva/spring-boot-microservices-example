package io.codebyexample.servicea.dataprovider.grpcapi.servicec;


import io.codebyexample.servicea.core.entity.MessageC;

/**
 * @author huypva
 * */
public interface ServiceCApi {

  void setMessage(MessageC messageC);

  String getMessage(int id);
}
