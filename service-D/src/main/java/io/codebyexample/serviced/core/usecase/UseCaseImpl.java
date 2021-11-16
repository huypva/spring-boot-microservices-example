package io.codebyexample.serviced.core.usecase;

import io.codebyexample.serviced.core.entity.MessageD;
import io.codebyexample.serviced.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 * */
@Slf4j
@Component
public class UseCaseImpl implements UseCase {

  @Override
  public void processDMessage(MessageD dMessage) {
    log.info("processDMessage message {}", GsonUtils.toJson(dMessage));
  }
}
