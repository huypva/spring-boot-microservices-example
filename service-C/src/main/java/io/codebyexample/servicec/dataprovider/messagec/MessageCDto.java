package io.codebyexample.servicec.dataprovider.messagec;

import javax.persistence.*;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author huypva
 * */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "message_c")
public class MessageCDto {

  @Id
  @Column(name = "message_id")
  private int id;

  @Column(name = "message")
  private String message;
}
