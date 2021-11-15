package io.codebyexample.serviceb.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/** @author huypva */
@Getter
@Setter
@Builder
public class BMessage implements Serializable {

  long msgId;
}
