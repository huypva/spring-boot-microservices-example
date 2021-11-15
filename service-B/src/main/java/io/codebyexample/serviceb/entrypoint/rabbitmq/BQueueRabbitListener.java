package io.codebyexample.serviceb.entrypoint.rabbitmq;

import io.codebyexample.serviceb.core.entity.BMessage;
import io.codebyexample.serviceb.core.usercase.greeter.BUseCase;
import io.codebyexample.serviceb.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** @author sateam */
@Slf4j
@Component
@RabbitListener(queues = "B_QUEUE")
public class BQueueRabbitListener {

  @Autowired
  BUseCase bUseCase;

  @RabbitHandler
  public void consume(BMessage bMessage) throws InterruptedException {
    log.info("BQueueRabbitListener.consume " + GsonUtils.toJson(bMessage));
    bUseCase.processMessage(bMessage);
  }

}
