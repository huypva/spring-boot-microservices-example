package io.codebyexample.servicec.core.usecase;


import io.codebyexample.servicec.core.entity.MessageC;

/**
 * @author huypva
 */
public interface CUseCase {

  void setMessageC(MessageC messageC);

  MessageC getMessageC(int messageC);
}
