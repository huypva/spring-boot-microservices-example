package io.codebyexample.servicec.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Base64;

/** @author sateam */
public final class GsonUtils {

  private static final Gson GSON =
      new GsonBuilder()
          .registerTypeAdapter(
              byte[].class,
              new TypeAdapter<byte[]>() {
                @Override
                public void write(JsonWriter out, byte[] value) throws IOException {
                  out.value(Base64.getEncoder().encodeToString(value));
                }

                @Override
                public byte[] read(JsonReader in) throws IOException {
                  return Base64.getDecoder().decode(in.nextString());
                }
              })
          .create();

  private GsonUtils() {}

  public static <T> T fromJson(String json, Class<T> clazz) {
    return GSON.fromJson(json, clazz);
  }

  public static <T> T fromJson(String json, Type type) {
    return GSON.fromJson(json, type);
  }

  public static String toJson(Object obj) {
    return GSON.toJson(obj);
  }
}
