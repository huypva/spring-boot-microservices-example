package io.codebyexample.servicec.core.usecase;

import io.codebyexample.servicec.core.entity.MessageC;
import io.codebyexample.servicec.dataprovider.messagec.MessageCDataProvider;
import io.codebyexample.servicec.exception.MessageNotFoundException;
import io.codebyexample.servicec.util.GsonUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huypva
 */
@Slf4j
@AllArgsConstructor
@Service
public class UseCaseCImpl implements UseCaseC {

    @Autowired
    private MessageCDataProvider messageCDataProvider;

    @Override
    public void setMessageC(MessageC messageC) {
        log.info("CUseCase.setMessageC: " + GsonUtils.toJson(messageC));
        messageCDataProvider.setMessageC(messageC);
    }

    @Override
    public MessageC getMessageC(int id) {
        MessageC messageC = messageCDataProvider.getMessageC(id);
        if (messageC == null) {
            throw new MessageNotFoundException("Not found message by id" + id);
        }

        return messageC;
    }
}
