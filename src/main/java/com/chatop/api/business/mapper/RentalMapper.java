package com.chatop.api.business.mapper;

import com.chatop.api.business.entity.Rental;
import com.chatop.api.service.DTO.RentalDTO;
import org.springframework.stereotype.Component;

@Component
public class RentalMapper {

    /**
     * Converts a RentalDTO object into a Rental object
     *
     * @param rentalDTO as the RentalDTO to convert
     * @return RentalDTO
     */
    public Rental convertToEntity(RentalDTO rentalDTO) {
        if (rentalDTO == null) return null;

        Rental rental = new Rental();
        rental.setName(rentalDTO.getName());
        rental.setSurface(rentalDTO.getSurface());
        rental.setPrice(rentalDTO.getPrice());
        // ADD PICTURE
        rental.setDescription(rentalDTO.getDescription());

        return rental;
    }

    /**
     * Converts a Rental object into a RentalDTO object
     *
     * @param rental as the rental to convert
     * @return Rental
     */
    public RentalDTO convertToDTO(Rental rental) {
        if (rental == null) return null;

        RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setName(rental.getName());
        rentalDTO.setSurface(rental.getSurface());
        rentalDTO.setPrice(rental.getPrice());
        rentalDTO.setDescription(rental.getDescription());

        return rentalDTO;
    }
}
