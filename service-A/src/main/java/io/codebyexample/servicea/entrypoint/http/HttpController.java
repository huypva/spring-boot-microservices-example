package io.codebyexample.servicea.entrypoint.http;

import io.codebyexample.servicea.core.entity.MessageB;
import io.codebyexample.servicea.core.entity.MessageC;
import io.codebyexample.servicea.core.entity.MessageD;
import io.codebyexample.servicea.core.usercase.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huypva
 */
@RestController
public class HttpController {

  @Autowired
  private UseCase useCase;

  @RequestMapping(value = "/call_service_b", method = RequestMethod.POST)
  public String callServiceB(@RequestBody MessageB bMessage) {
    return useCase.callServiceB(bMessage);
  }

  @RequestMapping(value = "/call_service_c/{id}", method = RequestMethod.GET)
  public String callServiceC(@PathVariable("id") int id,
      @RequestParam("message") String message) {
    MessageC messageC = MessageC.builder()
        .id(id)
        .message(message)
        .build();
    return useCase.callServiceC(messageC);
  }

  @RequestMapping(value = "/call_service_d/{id}", method = RequestMethod.GET)
  public String callServiceD(@PathVariable("userId") long userId,
      @RequestParam("bankId") int bankId,
      @RequestBody String message) {
    MessageD messageD = MessageD.builder().build();
    return useCase.callServiceD(messageD);
  }

}
