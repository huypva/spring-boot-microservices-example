package io.codebyexample.servicec.dataprovider.messagec;

import io.codebyexample.servicec.core.entity.MessageC;
import io.codebyexample.servicec.dataprovider.messagec.jpa.MessageCDTO;
import io.codebyexample.servicec.dataprovider.messagec.jpa.MessageCRepository;
import io.codebyexample.servicec.dataprovider.messagec.redis.MessageCRedisClient;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Component
public class MessageCDataProviderImpl implements MessageCDataProvider {

  @Autowired
  private MessageCRepository messageCRepository;

  @Autowired
  private MessageCRedisClient messageCRedisClient;

  @Override
  public void setMessageC(MessageC messageC) {
    messageCRedisClient.setMessageC(messageC);
    MessageCDTO messageCDto = new MessageCDTO(messageC.getId(), messageC.getMessage());
    messageCRepository.save(messageCDto);
  }

  @Override
  public MessageC getMessageC(int id) {
    MessageC messageC = messageCRedisClient.getMessageC(id);
    if (messageC != null) {
      return messageC;
    }

    Optional<MessageCDTO> optionalMessageCDTO = messageCRepository.findById(id);
    if (optionalMessageCDTO.isPresent()) {
      MessageCDTO messageCDTO = optionalMessageCDTO.get();
      messageC = MessageC.builder()
          .id(messageCDTO.getId())
          .message(messageCDTO.getMessage())
          .build();
      messageCRedisClient.setMessageC(messageC);
    }

    return messageC;
  }
}
