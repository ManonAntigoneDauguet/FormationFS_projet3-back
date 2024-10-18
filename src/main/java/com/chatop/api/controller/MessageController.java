package com.chatop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.api.model.Message;
import com.chatop.api.model.RequestNotification;
import com.chatop.api.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	/**
	 * Creates a message
	 * 
	 * @param message
	 * @return notification
	 */
	@PostMapping("/messages")
	public RequestNotification createMessage(@RequestBody Message message) {
		return messageService.createMessage(message);
	}
}
