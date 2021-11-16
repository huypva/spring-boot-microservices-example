package io.codebyexample.servicec.dataprovider.messagec;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author huypva
 * */
public interface CRepository extends JpaRepository<MessageCDto, Integer> {

}
