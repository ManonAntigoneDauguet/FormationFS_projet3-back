package com.chatop.api.service.controller;

import java.util.Optional;

import com.chatop.api.service.DTO.RentalDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
	 * @param id
	 * @return rental
	 */
	@GetMapping("/rentals/{id}")
	public Optional<Rental> getRentalById(@PathVariable("id") final Long id) {
		Optional<Rental> rental = rentalService.getRentalById(id);
		return rental.isPresent() ? rental : null;
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
}
