package com.chatop.api.service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RentalDTO {

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "surface is required")
    @Positive(message = "surface must be a positive number")
    private Double surface;

    @NotNull(message = "price is required")
    @Positive(message = "price must be a positive number")
    private Double price;

    @NotBlank(message = "description is required")
    private String description;

    // ADD PICTURE
}
