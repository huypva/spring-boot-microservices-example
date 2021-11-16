package io.codebyexample.serviceb.core.usercase;

import io.codebyexample.serviceb.core.entity.BMessage;
import io.codebyexample.serviceb.dataprovider.messaging.rabbitmq.RabbitProvider;
import io.codebyexample.serviceb.util.GsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** @author sateam */
@Slf4j
@Component
@RequiredArgsConstructor
public class BUseCaseImpl implements BUseCase {

  @Autowired
  private final RabbitProvider rabbitProvider;

  @Override
  public void methodB(long id) {
    log.info("BUseCase.methodB id={}", id);

    BMessage bMessage = BMessage.builder()
        .msgId(id)
        .build();

    rabbitProvider.sendBMessage(bMessage);
  }

  @Override
  public void processMessage(BMessage bMessage) {
    log.info("BUseCase.processBMessage: " + GsonUtils.toJson(bMessage));
  }


}
