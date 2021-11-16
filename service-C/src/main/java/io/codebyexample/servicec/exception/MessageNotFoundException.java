package io.codebyexample.servicec.exception;

/**
 * @author huypva
 */
public class MessageNotFoundException extends RuntimeException {

  public MessageNotFoundException(String message) {
    super(message);
  }
}
