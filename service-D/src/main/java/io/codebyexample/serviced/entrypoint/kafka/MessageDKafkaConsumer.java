package io.codebyexample.serviced.entrypoint.kafka;


import io.codebyexample.serviced.core.entity.MessageD;
import io.codebyexample.serviced.core.usecase.UseCase;
import io.codebyexample.serviced.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author huypva
 * */
@Slf4j
@Service
public class MessageDKafkaConsumer {

  @Autowired
  UseCase dUseCase;

  @KafkaListener(topics = "D_TOPIC", groupId = "serviced")
  public void consume(ConsumerRecord<String, String> record) {
    try {
      log.info(
          "Consumed - Partition: {} - Offset: {} - Value: {}",
          record.partition(),
          record.offset(),
          record.value());
      record.headers().forEach(s -> System.out.println(s.key() + "->" + new String(s.value())));

      MessageD userMessage = GsonUtils.fromJson(record.value(), MessageD.class);
      dUseCase.processDMessage(userMessage);

    } catch (Exception ex) {
      log.error("Exception - Reason:", ex);
    }
  }
}
