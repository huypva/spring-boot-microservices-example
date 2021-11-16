package io.codebyexample.servicec.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author huypva
 * */
@Getter
@Setter
@Builder
public class MessageC {

  int id;
  String message;
}
