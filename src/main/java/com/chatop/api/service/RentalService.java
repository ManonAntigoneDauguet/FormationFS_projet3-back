package com.chatop.api.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.api.model.Rental;
import com.chatop.api.model.ApiResponse;
import com.chatop.api.repository.RentalRepository;

import lombok.Data;

@Data
@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;

	/**
	 * Finds all the rentals
	 * 
	 * @return all rentals
	 */
	public Iterable<Rental> getRentals() {
		return rentalRepository.findAll();
	}

	/**
	 * Finds the rental by id
	 * 
	 * @param id
	 * @return rental
	 */
	public Optional<Rental> getRentalById(Long id) {
		return rentalRepository.findById(id);
	}

	/**
	 * Saves the rental
	 * 
	 * @param rental
	 * @return notification
	 */
	public ApiResponse createRental(Rental rental) {
		rentalRepository.save(rental);
		return new ApiResponse("Rental created !");
	}

	public ApiResponse updateRental(Long id, Rental rental) {
		Optional<Rental> oldRental = rentalRepository.findById(id);

		if (oldRental.isPresent()) {
			Rental updatedRental = oldRental.get();
			updatedRental.setName(oldRental.get().getName());
			updatedRental.setSurface(oldRental.get().getSurface());
			updatedRental.setPrice(oldRental.get().getPrice());
			updatedRental.setDescription(oldRental.get().getDescription());
			updatedRental.setUpdatedAt(LocalDateTime.now());
		}

		return new ApiResponse("Rental updated !");
	}
}
