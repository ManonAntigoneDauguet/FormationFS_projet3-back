package com.chatop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.api.model.DTO.MessageDTO;
import com.chatop.api.model.apiResponse.ApiMessageResponse;
import com.chatop.api.service.MessageService;

import jakarta.validation.Valid;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	/**
	 * Creates a message
	 * 
	 * @param messageDTO as the message to send
	 * @return notification
	 */
	@PostMapping("/messages")
	public ResponseEntity<ApiMessageResponse> createMessage(@Valid @RequestBody MessageDTO messageDTO) {
		return messageService.createMessage(messageDTO);
	}
}
