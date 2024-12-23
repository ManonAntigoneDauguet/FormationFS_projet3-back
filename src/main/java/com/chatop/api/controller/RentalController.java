package com.chatop.api.controller;

import com.chatop.api.business.entity.Rental;
import com.chatop.api.service.RentalService;
import com.chatop.api.common.DTO.apiRequest.RentalPostRequestDTO;
import com.chatop.api.common.DTO.apiRequest.RentalPutRequestDTO;
import com.chatop.api.common.DTO.apiResponse.ApiMessageResponse;
import com.chatop.api.common.DTO.apiResponse.ApiRentalResponse;
import com.chatop.api.common.DTO.apiResponse.RentalResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RentalController {

    @Autowired
    private RentalService rentalService;

    /**
     * Returns all the rentals
     *
     * @return all rentals
     */
    @GetMapping("/rentals")
    public ResponseEntity<ApiRentalResponse> getRentals() {
        Iterable<RentalResponseDTO> rentals = rentalService.getRentals();
        return ResponseEntity.ok(new ApiRentalResponse(rentals));
    }

    /**
     * Returns the rental's information
     *
     * @param id as the rental id
     * @return rental
     */
    @GetMapping("/rentals/{id}")
    public ResponseEntity<RentalResponseDTO> getRentalById(@PathVariable("id") final Long id) {
        RentalResponseDTO rental = rentalService.getRentalById(id);
        return ResponseEntity.ok(rental);
    }

    /**
     * Creates a rental
     *
     * @param rentalPostRequestDTO as the rental to create
     * @return notification
     */
    @PostMapping("/rentals")
    public ResponseEntity<ApiMessageResponse> createRental(@Valid @ModelAttribute RentalPostRequestDTO rentalPostRequestDTO) {
        rentalService.createRental(rentalPostRequestDTO);
        return ResponseEntity.ok(new ApiMessageResponse("Rental created !"));
    }

    @PutMapping("/rentals/{id}")
    public ResponseEntity<ApiMessageResponse> updateRental(@Valid @ModelAttribute RentalPutRequestDTO updatedData, @PathVariable("id") final Long id) {
        Rental oldRental = rentalService.findRentalById(id);
        if (!rentalService.checkIfOwnRental(oldRental))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiMessageResponse("You can only update your own rentals"));
        rentalService.updateRental(oldRental, updatedData);
        return ResponseEntity.ok(new ApiMessageResponse("Rental updated !"));
    }
}
