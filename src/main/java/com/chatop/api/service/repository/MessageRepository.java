package com.chatop.api.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatop.api.business.entity.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}
