package com.chatop.api.service.DTO.apiResponse;

import com.chatop.api.business.entity.Rental;
import lombok.Data;

@Data
public class ApiRentalResponse implements ApiResponse {

    private Iterable<Rental> rentals;

    public ApiRentalResponse(Iterable<Rental> rentals) {

        this.rentals = rentals;
    }
}
