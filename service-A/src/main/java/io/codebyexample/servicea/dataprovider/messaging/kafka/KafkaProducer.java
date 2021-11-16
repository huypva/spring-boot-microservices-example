package io.codebyexample.servicea.dataprovider.messaging.kafka;


import io.codebyexample.servicea.core.entity.MessageD;

/**
 * @author huypva
 * */
public interface KafkaProducer {

  void sendMessageD(MessageD messageD);
}
