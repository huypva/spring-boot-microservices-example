package io.codebyexample.servicea.core.usercase;

import io.codebyexample.servicea.core.entity.MessageB;
import io.codebyexample.servicea.core.entity.MessageC;
import io.codebyexample.servicea.core.entity.MessageD;

/**
 * @author huypva
 * */
public interface UseCase {

  String callServiceB(MessageB messageB);

  void setMessageC(MessageC messageC);

  String getMessageC(int id);

  void sendMessageD(MessageD messageD);
}
