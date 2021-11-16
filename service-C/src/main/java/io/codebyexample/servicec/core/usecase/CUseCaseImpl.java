package io.codebyexample.servicec.core.usecase;

import io.codebyexample.servicec.core.entity.MessageC;
import io.codebyexample.servicec.dataprovider.messagec.CRepository;
import io.codebyexample.servicec.dataprovider.messagec.MessageCDto;
import io.codebyexample.servicec.exception.MessageNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huypva
 */
@AllArgsConstructor
@Service
public class CUseCaseImpl implements CUseCase {

    @Autowired
    private CRepository cRepository;

    @Override
    public void setMessageC(MessageC messageC) {
        MessageCDto messageCDto = new MessageCDto(messageC.getId(), messageC.getMessage());
        cRepository.save(messageCDto);
    }

    @Override
    public MessageC getMessageC(int id) {
        MessageCDto messageCDto = cRepository.findById(id)
            .orElseThrow(() -> new MessageNotFoundException(String.format("Not found message by id %s", id)));

        return MessageC.builder()
            .id(messageCDto.getId())
            .message(messageCDto.getMessage())
            .build();
    }
}
