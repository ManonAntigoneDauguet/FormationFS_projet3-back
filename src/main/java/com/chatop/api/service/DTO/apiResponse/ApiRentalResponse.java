package com.chatop.api.service.DTO.apiResponse;

import lombok.Data;

@Data
public class ApiRentalResponse implements ApiResponse {

    private Iterable<RentalResponseDTO> rentals;

    public ApiRentalResponse(Iterable<RentalResponseDTO> rentals) {
        this.rentals = rentals;
    }
}
