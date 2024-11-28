package com.chatop.api.controller;

import com.chatop.api.service.MessageService;
import com.chatop.api.common.DTO.MessageDTO;
import com.chatop.api.common.DTO.apiResponse.ApiMessageResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
		messageService.createMessage(messageDTO);
		return ResponseEntity.ok(new ApiMessageResponse("Message send with success"));
	}
}
