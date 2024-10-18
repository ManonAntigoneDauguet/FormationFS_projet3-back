package com.chatop.api.mapper;

import com.chatop.api.model.DTO.MessageDTO;
import com.chatop.api.model.database.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageMapper {

    /**
     * Converts a MessageDTO object into a Message object
     *
     * @param messageDTO as the MessageDTO to convert
     * @return Message
     */
    public Message convertToEntity(MessageDTO messageDTO) {
        if (messageDTO == null) return null;

        Message message = new Message();
        message.setMessage(messageDTO.getMessage());
        message.setRentalId(messageDTO.getRental_id());
        message.setUserId(messageDTO.getUser_id());
        message.setCreatedAt(LocalDateTime.now());
        message.setUpdatedAt(LocalDateTime.now());

        return message;
    }

    /**
     * Converts a Message object into a MessageDTO object
     *
     * @param message as the message to convert
     * @return Message
     */
    public MessageDTO convertToDTO(Message message) {
        if (message == null) return null;

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessage(message.getMessage());
        messageDTO.setRental_id(message.getRentalId());
        messageDTO.setUser_id(message.getUserId());

        return messageDTO;
    }
}
