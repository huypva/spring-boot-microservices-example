package io.codebyexample.servicec.dataprovider.messagec.redis;

import io.codebyexample.servicec.core.entity.MessageC;

/**
 * @author huypva
 */
public interface MessageCRedisClient {

  void setMessageC(MessageC messageC);

  MessageC getMessageC(int id);

}
