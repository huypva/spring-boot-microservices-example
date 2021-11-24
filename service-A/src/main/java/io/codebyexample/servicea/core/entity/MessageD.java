package io.codebyexample.servicea.core.entity;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author huypva
 * */
@Getter
@Setter
@Builder
public class MessageD {

  int id;
  String message;
}
