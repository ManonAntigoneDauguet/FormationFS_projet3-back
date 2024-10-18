package com.chatop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.api.model.Message;
import com.chatop.api.model.RequestNotification;
import com.chatop.api.repository.MessageRepository;

import lombok.Data;

@Data
@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	/**
	 * Saves the message
	 * @param message
	 * @return notification
	 */
	public RequestNotification createMessage(Message message) {
		messageRepository.save(message);
		
		RequestNotification notification = new RequestNotification();
		notification.setMessage("Message send with success");
		return notification;
	}
}
