package io.codebyexample.servicec.util;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.JsonFormat.Printer;
import com.google.rpc.ErrorInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * @author huypva
 */
@Slf4j
public final class ProtobufUtils {
  private static final JsonFormat.TypeRegistry TYPE_REGISTRY =
      JsonFormat.TypeRegistry.newBuilder().add(ErrorInfo.getDescriptor()).build();

  private static final Printer PRINTER =
      JsonFormat.printer()
          .omittingInsignificantWhitespace()
          .includingDefaultValueFields()
          .usingTypeRegistry(TYPE_REGISTRY);

  private ProtobufUtils() {}

  public static String print(MessageOrBuilder message) {
    try {
      return PRINTER.print(message);
    } catch (Exception ex) {
      log.error("Reason:", ex);
    }
    return null;
  }
}
