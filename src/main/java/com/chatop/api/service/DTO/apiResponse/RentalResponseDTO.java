package com.chatop.api.service.DTO.apiResponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class RentalResponseDTO {
    private Long id;

    private String name;

    private Double surface;

    private Double price;

    // ADD PICTURE

    private String description;

    private Integer ownerId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date updatedAt;
}
