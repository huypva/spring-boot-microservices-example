package io.codebyexample.servicea.dataprovider.messaging.kafka;

import io.codebyexample.servicea.core.entity.MessageD;
import io.codebyexample.servicea.util.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author huypva
 * */
@Slf4j
@Service
public class KafkaProducerImpl implements KafkaProducer {

  @Autowired
  KafkaTemplate<String, String> userKafka;

  @Override
  public void sendMessageD(MessageD messageD) {
    userKafka.send("MessageD", GsonUtils.toJson(messageD))
        .addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

          @Override
          public void onSuccess(SendResult<String, String> result) {
            log.info("Kafka sent message='{}' with offset={}", messageD,
                result.getRecordMetadata().offset());
          }

          @Override
          public void onFailure(Throwable ex) {
            log.error("Kafka unable to send message='{}'", messageD, ex);
          }
        });
  }
}
