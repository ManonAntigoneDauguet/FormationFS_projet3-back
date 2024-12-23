package com.chatop.api.common.DTO.apiRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RentalPostRequestDTO {

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
