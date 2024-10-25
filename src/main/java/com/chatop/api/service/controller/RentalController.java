package com.chatop.api.service.controller;

import com.chatop.api.service.DTO.RentalDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chatop.api.service.DTO.apiResponse.ApiMessageResponse;
import com.chatop.api.business.entity.Rental;
import com.chatop.api.business.service.RentalService;

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
    public Iterable<Rental> getRentals() {
        return rentalService.getRentals();
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rental not found");
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
        return rentalService.createRental(rentalDTO);
    }

    @PutMapping("/rentals/{id}")
    public ResponseEntity<ApiMessageResponse> updateRental(@Valid @ModelAttribute RentalDTO updatedData, @PathVariable("id") final Long id) {
        try {
            Rental oldRental = rentalService.getRentalById(id);
            System.out.println(oldRental);
            return rentalService.updateRental(oldRental, updatedData);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiMessageResponse("Rental not found"));
        }
    }
}
