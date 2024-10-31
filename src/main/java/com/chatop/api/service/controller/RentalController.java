package com.chatop.api.service.controller;

import com.chatop.api.business.entity.Rental;
import com.chatop.api.business.service.RentalService;
import com.chatop.api.service.DTO.apiRequest.RentalRequestDTO;
import com.chatop.api.service.DTO.apiResponse.ApiMessageResponse;
import com.chatop.api.service.DTO.apiResponse.ApiRentalResponse;
import com.chatop.api.service.DTO.apiResponse.RentalResponseDTO;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<Object> getRentalById(@PathVariable("id") final Long id) {
        try {
            RentalResponseDTO rental = rentalService.getRentalById(id);
            return ResponseEntity.ok(rental);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * Creates a rental
     *
     * @param rentalRequestDTO as the rental to create
     * @return notification
     */
    @PostMapping("/rentals")
    public ResponseEntity<ApiMessageResponse> createRental(@Valid @ModelAttribute RentalRequestDTO rentalRequestDTO) {
        rentalService.createRental(rentalRequestDTO);
        return ResponseEntity.ok(new ApiMessageResponse("Rental created !"));
    }

    @PutMapping("/rentals/{id}")
    public ResponseEntity<ApiMessageResponse> updateRental(@Valid @ModelAttribute RentalRequestDTO updatedData, @PathVariable("id") final Long id) {
        try {
            Rental oldRental = rentalService.findRentalById(id);
            rentalService.updateRental(oldRental, updatedData);
            return ResponseEntity.ok(new ApiMessageResponse("Rental updated !"));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiMessageResponse(e.getMessage()));
        }
    }
}
