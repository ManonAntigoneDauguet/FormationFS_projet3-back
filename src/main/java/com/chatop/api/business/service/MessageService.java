package com.chatop.api.business.service;

import com.chatop.api.business.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.api.service.DTO.MessageDTO;
import com.chatop.api.business.entity.Message;
import com.chatop.api.service.repository.MessageRepository;

import lombok.Data;

import java.time.LocalDateTime;

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
     */
	public void createMessage(MessageDTO messageDTO) {
		Message message = messageMapper.convertToEntity(messageDTO);
		message.setCreatedAt(LocalDateTime.now());
		message.setUpdatedAt(LocalDateTime.now());
		messageRepository.save(message);
	}
}
