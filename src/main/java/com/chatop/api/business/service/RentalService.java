package com.chatop.api.business.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.chatop.api.business.mapper.RentalMapper;
import com.chatop.api.service.DTO.RentalDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chatop.api.service.DTO.apiResponse.ApiMessageResponse;
import com.chatop.api.business.entity.Rental;
import com.chatop.api.service.repository.RentalRepository;

import lombok.Data;

@Data
@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;

	@Autowired
	private RentalMapper rentalMapper;

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
	 * @param id as the rental id
	 * @return rental
	 */
	public Optional<Rental> getRentalById(Long id) {

		return rentalRepository.findById(id);
	}

	/**
	 * Saves the rental
	 * 
	 * @param rentalDTO as the rental to create
	 * @return notification
	 */
	public ResponseEntity<ApiMessageResponse> createRental(RentalDTO rentalDTO) {
		Rental rental = rentalMapper.convertToEntity(rentalDTO);
		rentalRepository.save(rental);
		return ResponseEntity.ok(new ApiMessageResponse("Rental created !"));
	}

	public ApiMessageResponse updateRental(Long id, Rental rental) {
		Optional<Rental> oldRental = rentalRepository.findById(id);

		if (oldRental.isPresent()) {
			Rental updatedRental = oldRental.get();
			updatedRental.setName(oldRental.get().getName());
			updatedRental.setSurface(oldRental.get().getSurface());
			updatedRental.setPrice(oldRental.get().getPrice());
			updatedRental.setDescription(oldRental.get().getDescription());
			updatedRental.setUpdatedAt(LocalDateTime.now());
		}

		return new ApiMessageResponse("Rental updated !");
	}
}
