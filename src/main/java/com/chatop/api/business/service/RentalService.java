package com.chatop.api.business.service;

import com.chatop.api.business.entity.Rental;
import com.chatop.api.business.mapper.RentalMapper;
import com.chatop.api.service.DTO.apiRequest.RentalPostRequestDTO;
import com.chatop.api.service.DTO.apiRequest.RentalPutRequestDTO;
import com.chatop.api.service.DTO.apiResponse.RentalResponseDTO;
import com.chatop.api.service.repository.RentalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private RentalMapper rentalMapper;

    @Autowired
    private UserService userService;

    /**
     * Finds all the rentals
     *
     * @return all rentals
     */
    public Iterable<RentalResponseDTO> getRentals() {
        Iterable<Rental> rentals = rentalRepository.findAll();
        List<RentalResponseDTO> rentalsDTO = new ArrayList<>();

        for (Rental rental : rentals) {
            rentalsDTO.add(rentalMapper.convertToResponseDTO(rental));
        }

        return rentalsDTO;
    }

    /**
     * Finds the rental by id and return the RentalResponseDTO
     *
     * @param id as the rental id
     * @return RentalResponseDTO
     */
    public RentalResponseDTO getRentalById(Long id) {
        return rentalMapper.convertToResponseDTO((findRentalById(id)));
    }

    /**
     * Finds the rental by id and return the entity
     *
     * @param id as the rental id
     * @return Rental
     */
    public Rental findRentalById(Long id) {
        return rentalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rental not found"));
    }

    /**
     * Saves the rental
     *
     * @param rentalPostRequestDTO as the rental to create
     */
    public void createRental(RentalPostRequestDTO rentalPostRequestDTO) {
        Date today = Date.from(new Date().toInstant());
        Long ownerId = userService.getUserByAuthentication().getId();

        try {
            Rental rental = rentalMapper.convertToEntity(rentalPostRequestDTO);
            rental.setCreatedAt(today);
            rental.setUpdatedAt(today);
            rental.setOwnerId(ownerId);
            rentalRepository.save(rental);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @param oldRental   as the found rental
     * @param updatedData as the RentalDTO with the new information
     */
    public void updateRental(Rental oldRental, RentalPutRequestDTO updatedData) {
        Date today = Date.from(new Date().toInstant());

        oldRental.setName(updatedData.getName());
        oldRental.setSurface(updatedData.getSurface());
        oldRental.setPrice(updatedData.getPrice());
        oldRental.setDescription(updatedData.getDescription());
        oldRental.setUpdatedAt(today);
        rentalRepository.save(oldRental);
    }

    /**
     * Checks if the rental belongs to the connected user
     *
     * @param rental as Rental entity
     * @return boolean
     */
    public boolean checkIfOwnRental(Rental rental) {
        Long ownerId = userService.getUserByAuthentication().getId();
        return rental.getOwnerId().equals(ownerId);
    }
}
