package com.chatop.api.business.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.chatop.api.business.mapper.RentalMapper;
import com.chatop.api.service.DTO.RentalDTO;
import jakarta.persistence.EntityNotFoundException;
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
	public Rental getRentalById(Long id) {
		return rentalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rental not found"));
	}

	/**
	 * Saves the rental
	 * 
	 * @param rentalDTO as the rental to create
	 * @return notification
	 */
	public ResponseEntity<ApiMessageResponse> createRental(RentalDTO rentalDTO) {
		Rental rental = rentalMapper.convertToEntity(rentalDTO);
		rental.setCreatedAt(LocalDateTime.now());
		rental.setUpdatedAt(LocalDateTime.now());

		rentalRepository.save(rental);
		return ResponseEntity.ok(new ApiMessageResponse("Rental created !"));
	}

	/**
	 *
	 * @param oldRental as the found rental
	 * @param updatedData as the RentalDTO with the new information
	 * @return notification
	 */
	public ResponseEntity<ApiMessageResponse> updateRental(Rental oldRental, RentalDTO updatedData) {
		oldRental.setName(updatedData.getName());
		oldRental.setSurface(updatedData.getSurface());
		oldRental.setPrice(updatedData.getPrice());
		oldRental.setDescription(updatedData.getDescription());
		oldRental.setUpdatedAt(LocalDateTime.now());

		rentalRepository.save(oldRental);
		return ResponseEntity.ok(new ApiMessageResponse("Rental updated !"));
	}
}
