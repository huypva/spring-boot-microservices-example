package io.codebyexample.servicea.util.common.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/** @author sateam */
@Getter
public enum ReasonEnum {
  SUCCESS(0),
  EXCEPTION(-1),
  REQUEST_IS_NOT_AUTHENTICATED(-2),
  REQUEST_IS_NOT_AUTHORIZED(-3),
  REQUEST_FORMAT_IS_INVALID(-4);

  private static final Map<Integer, ReasonEnum> REASON_ENUM_MAP = new HashMap<>();

  static {
    for (ReasonEnum reasonEnum : ReasonEnum.values()) {
      REASON_ENUM_MAP.put(reasonEnum.value, reasonEnum);
    }
  }

  private final int value;

  ReasonEnum(int value) {
    this.value = value;
  }
}
