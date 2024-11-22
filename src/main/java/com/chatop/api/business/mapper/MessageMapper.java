package com.chatop.api.business.mapper;

import com.chatop.api.service.DTO.MessageDTO;
import com.chatop.api.business.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    /**
     * Converts a MessageDTO object into a Message object
     *
     * @param messageDTO as the MessageDTO to convert
     * @return Message
     */
    public Message convertToEntity(MessageDTO messageDTO) {
        Message message = new Message();
        message.setMessage(messageDTO.getMessage());
        message.setRentalId(messageDTO.getRental_id());
        message.setUserId(messageDTO.getUser_id());

        return message;
    }

    /**
     * Converts a Message object into a MessageDTO object
     *
     * @param message as the Message to convert
     * @return MessageDTO
     */
    public MessageDTO convertToDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessage(message.getMessage());
        messageDTO.setRental_id(message.getRentalId());
        messageDTO.setUser_id(message.getUserId());

        return messageDTO;
    }
}
