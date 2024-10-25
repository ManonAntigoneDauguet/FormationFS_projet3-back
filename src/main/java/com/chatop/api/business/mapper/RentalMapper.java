package com.chatop.api.business.mapper;

import com.chatop.api.business.entity.Rental;
import com.chatop.api.service.DTO.RentalDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RentalMapper {

    /**
     * Converts a RentalDTO object into a Rental object
     *
     * @param rentalDTO as the RentalDTO to convert
     * @return Message
     */
    public Rental convertToEntity(RentalDTO rentalDTO) {
        if (rentalDTO == null) return null;

        Rental rental = new Rental();
        rental.setName(rentalDTO.getName());
        rental.setSurface(rentalDTO.getSurface());
        rental.setPrice(rentalDTO.getPrice());
        // ADD PICTURE
        rental.setDescription(rentalDTO.getDescription());
        rental.setCreatedAt(LocalDateTime.now());
        rental.setUpdatedAt(LocalDateTime.now());

        return rental;
    }

    /**
     * Converts a Message object into a MessageDTO object
     *
     * @param rental as the rental to convert
     * @return Message
     */
    public RentalDTO convertToDTO(Rental rental) {
        if (rental == null) return null;

        RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setName(rentalDTO.getName());
        rentalDTO.setSurface(rentalDTO.getSurface());
        rentalDTO.setPrice(rentalDTO.getPrice());
        rentalDTO.setDescription(rentalDTO.getDescription());

        return rentalDTO;
    }
}
