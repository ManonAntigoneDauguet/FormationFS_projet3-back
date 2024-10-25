package com.chatop.api.service;

import com.chatop.api.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chatop.api.model.DTO.MessageDTO;
import com.chatop.api.model.apiResponse.ApiMessageResponse;
import com.chatop.api.model.database.Message;
import com.chatop.api.repository.MessageRepository;

import lombok.Data;

@Data
@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private MessageMapper messageMapper;

	/**
	 * Saves the message
	 * 
	 * @param messageDTO as the message to send
	 * @return notification
	 */
	public ResponseEntity<ApiMessageResponse> createMessage(MessageDTO messageDTO) {
		Message message = messageMapper.convertToEntity(messageDTO);
		messageRepository.save(message);
		return ResponseEntity.ok(new ApiMessageResponse("Message send with success"));
	}
}
