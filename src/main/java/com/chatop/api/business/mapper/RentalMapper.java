package com.chatop.api.business.mapper;

import com.chatop.api.business.entity.Rental;
import com.chatop.api.service.DTO.apiRequest.RentalRequestDTO;
import com.chatop.api.service.DTO.apiResponse.RentalResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class RentalMapper {

    /**
     * Converts a RentalRequestDTO object into a Rental object
     *
     * @param requestDTO as the RentalRequestDTO to convert
     * @return Rental
     */
    public Rental convertToEntity(RentalRequestDTO requestDTO) {
        Rental rental = new Rental();
        rental.setName(requestDTO.getName());
        rental.setSurface(requestDTO.getSurface());
        rental.setPrice(requestDTO.getPrice());
        // ADD PICTURE
        rental.setDescription(requestDTO.getDescription());

        return rental;
    }

    /**
     * Converts a Rental object into a RentalResponseDTO object
     *
     * @param rental as the rental to convert
     * @return RentalResponseDTO
     */
    public RentalResponseDTO convertToResponseDTO(Rental rental) {
        RentalResponseDTO responseDTO = new RentalResponseDTO();
        responseDTO.setName(rental.getName());
        responseDTO.setSurface(rental.getSurface());
        responseDTO.setPrice(rental.getPrice());
        // ADD PICTURE
        responseDTO.setDescription(rental.getDescription());
        responseDTO.setCreatedAt(rental.getCreatedAt());
        responseDTO.setUpdatedAt(rental.getUpdatedAt());

        return responseDTO;
    }
}
