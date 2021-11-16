package io.codebyexample.servicea.entrypoint.http;

import io.codebyexample.servicea.core.entity.MessageB;
import io.codebyexample.servicea.core.entity.MessageC;
import io.codebyexample.servicea.core.entity.MessageD;
import io.codebyexample.servicea.core.usercase.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @RequestMapping(value = "/message_c/{id}", method = RequestMethod.POST)
  public ResponseEntity setMessageC(@PathVariable("id") int id,
      @RequestParam("message") String message) {
    MessageC messageC = MessageC.builder()
        .id(id)
        .message(message)
        .build();
    useCase.setMessageC(messageC);

    return new ResponseEntity(HttpStatus.OK);
  }

  @RequestMapping(value = "/message_c/{id}", method = RequestMethod.GET)
  public String getMessageC(@PathVariable("id") int id) {
    return useCase.getMessageC(id);
  }

  @RequestMapping(value = "/send_message_d", method = RequestMethod.POST)
  public void sendMessageD(@RequestBody MessageD messageD) {
    useCase.sendMessageD(messageD);
  }

}
