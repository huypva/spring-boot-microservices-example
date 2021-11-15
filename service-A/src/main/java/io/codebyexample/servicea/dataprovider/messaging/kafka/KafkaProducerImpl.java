package io.codebyexample.servicea.dataprovider.messaging.kafka;

import io.codebyexample.servicea.core.entity.MessageB;
import io.codebyexample.servicea.util.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/** @author sateam */
@Slf4j
@Service
public class KafkaProducerImpl implements KafkaProducer {

  @Autowired
  KafkaTemplate<String, String> bankKafka;

  @Override
  public void publishToBank(MessageB bank) {
    bankKafka.send("hello1", GsonUtils.toJson(bank));
  }

  @Override
  public void notImplement(String message) {}
}
