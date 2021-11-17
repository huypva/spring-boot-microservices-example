package io.codebyexample.servicec.dataprovider.messagec;

import io.codebyexample.servicec.core.entity.MessageC;

/**
 * @author huypva
 */
public interface MessageCDataProvider {

  void setMessageC(MessageC messageC);

  MessageC getMessageC(int id);

}
