package io.codebyexample.serviceb.core.usercase;

import io.codebyexample.serviceb.core.entity.BMessage;

/** @author sateam */
public interface BUseCase {

  void methodB(long id);

  void processMessage(BMessage bMessage);
}
