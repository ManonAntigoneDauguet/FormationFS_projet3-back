package com.chatop.api.business.mapper;

import com.chatop.api.business.entity.Rental;
import com.chatop.api.service.DTO.apiRequest.RentalRequestDTO;
import com.chatop.api.service.DTO.apiResponse.RentalResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.chatop.api.common.Utils.uploadFile;

@Component
public class RentalMapper {

    @Value("${server.base-pictures-url}")
    private String basePictureUrl;

    @Value("${path.saving.picture}")
    private String pathSavingPicture;

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
        rental.setDescription(requestDTO.getDescription());

        String fileName = uploadFile(requestDTO.getPicture(), pathSavingPicture);
        rental.setPicture(fileName);

        return rental;
    }

    /**
     * Converts a Rental object into a RentalResponseDTO object
     *
     * @param rental as the Rental to convert
     * @return RentalResponseDTO
     */
    public RentalResponseDTO convertToResponseDTO(Rental rental) {
        RentalResponseDTO responseDTO = new RentalResponseDTO();

        responseDTO.setId(rental.getId());
        responseDTO.setName(rental.getName());
        responseDTO.setSurface(rental.getSurface());
        responseDTO.setPrice(rental.getPrice());
        responseDTO.setPicture(basePictureUrl + rental.getPicture());
        responseDTO.setDescription(rental.getDescription());
        responseDTO.setOwnerId(rental.getOwnerId());
        responseDTO.setCreatedAt(rental.getCreatedAt());
        responseDTO.setUpdatedAt(rental.getUpdatedAt());

        return responseDTO;
    }
}
