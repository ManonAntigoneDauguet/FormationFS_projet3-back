package com.chatop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.api.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;
}
