package com.chatop.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chatop.api.model.ApiResponse;
import com.chatop.api.model.Message;
import com.chatop.api.model.DTO.MessageDTO;
import com.chatop.api.repository.MessageRepository;

import lombok.Data;

@Data
@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	/**
	 * Saves the message
	 * 
	 * @param messageDTO
	 * @return notification
	 */
	public ResponseEntity<ApiResponse> createMessage(MessageDTO messageDTO) {
		Message message = new Message();
		message.setMessage(messageDTO.getMessage());
		message.setRentalId(messageDTO.getRental_id());
		message.setUserlId(messageDTO.getUser_id());
		message.setCreatedAt(LocalDateTime.now());
		message.setUpdatedAt(LocalDateTime.now());

		messageRepository.save(message);
		return ResponseEntity.ok(new ApiResponse("Message send with success"));
	}
}
