package io.codebyexample.servicea.core.usercase;

import io.codebyexample.servicea.core.entity.MessageB;
import io.codebyexample.servicea.core.entity.MessageC;
import io.codebyexample.servicea.core.entity.MessageD;

/** @author huypva */
public interface UseCase {

  String callServiceB(MessageB messageB);

  String callServiceC(MessageC messageC);

  String callServiceD(MessageD messageD);
}
