package io.codebyexample.servicea.dataprovider.messaging.kafka;

import io.codebyexample.servicea.core.entity.MessageB;

/** @author sateam */
public interface KafkaProducer {

  void publishToBank(MessageB bank);

  void notImplement(String message);
}
