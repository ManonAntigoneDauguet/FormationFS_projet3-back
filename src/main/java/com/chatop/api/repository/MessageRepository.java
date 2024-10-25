package com.chatop.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatop.api.model.database.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}
