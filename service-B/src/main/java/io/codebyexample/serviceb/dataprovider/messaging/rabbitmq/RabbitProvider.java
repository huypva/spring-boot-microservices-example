package io.codebyexample.serviceb.dataprovider.messaging.rabbitmq;


import io.codebyexample.serviceb.core.entity.BMessage;

/** @author sateam */
public interface RabbitProvider {

  public void sendBMessage(BMessage user);
}
