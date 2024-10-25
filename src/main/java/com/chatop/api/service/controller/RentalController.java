package com.chatop.api.service.controller;

import com.chatop.api.business.entity.Rental;
import com.chatop.api.business.service.RentalService;
import com.chatop.api.service.DTO.RentalDTO;
import com.chatop.api.service.DTO.apiResponse.ApiMessageResponse;
import com.chatop.api.service.DTO.apiResponse.ApiRentalResponse;
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
        Iterable<Rental> rentals = rentalService.getRentals();
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
            Rental rental = rentalService.getRentalById(id);
            return ResponseEntity.ok(rental);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /**
     * Creates a rental
     *
     * @param rentalDTO as the rental to create
     * @return notification
     */
    @PostMapping("/rentals")
    public ResponseEntity<ApiMessageResponse> createRental(@Valid @ModelAttribute RentalDTO rentalDTO) {
        rentalService.createRental(rentalDTO);
        return ResponseEntity.ok(new ApiMessageResponse("Rental created !"));
    }

    @PutMapping("/rentals/{id}")
    public ResponseEntity<ApiMessageResponse> updateRental(@Valid @ModelAttribute RentalDTO updatedData, @PathVariable("id") final Long id) {
        try {
            Rental oldRental = rentalService.getRentalById(id);
            rentalService.updateRental(oldRental, updatedData);
            return ResponseEntity.ok(new ApiMessageResponse("Rental updated !"));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiMessageResponse(e.getMessage()));
        }
    }
}
