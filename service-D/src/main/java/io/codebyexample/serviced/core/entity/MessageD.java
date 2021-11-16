package io.codebyexample.serviced.core.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author huypva
 * */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class MessageD {

  @SerializedName("id")
  long id;

  @SerializedName("message")
  String message;
}
