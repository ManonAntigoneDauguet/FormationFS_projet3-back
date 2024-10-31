package com.chatop.api.service.DTO.apiRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;

@Data
public class RentalRequestDTO {

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "surface is required")
    @Positive(message = "surface must be a positive number")
    private Double surface;

    @NotNull(message = "picture is required")
    private MultipartFile picture;

    @NotNull(message = "price is required")
    @Positive(message = "price must be a positive number")
    private Double price;

    @NotBlank(message = "description is required")
    private String description;
}
