package com.chatop.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.api.model.apiResponse.ApiMessageResponse;
import com.chatop.api.model.database.Rental;
import com.chatop.api.service.RentalService;

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
	 * @param rental
	 * @return
	 */
	@PostMapping("/rentals")
	public ApiMessageResponse createRental(@RequestBody Rental rental) {
		return rentalService.createRental(rental);
	}
}
