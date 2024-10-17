package com.chatop.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chatop.api.model.Auth;

@Repository
public interface AuthRepository extends CrudRepository<Auth, Long> {

}
