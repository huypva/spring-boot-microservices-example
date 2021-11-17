package io.codebyexample.servicec.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author huypva
 * */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageC {

  int id;
  String message;
}
