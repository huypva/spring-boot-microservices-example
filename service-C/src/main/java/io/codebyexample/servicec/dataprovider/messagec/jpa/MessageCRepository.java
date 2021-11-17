package io.codebyexample.servicec.dataprovider.messagec.jpa;

import io.codebyexample.servicec.dataprovider.messagec.jpa.MessageCDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author huypva
 * */
public interface MessageCRepository extends JpaRepository<MessageCDTO, Integer> {

}
