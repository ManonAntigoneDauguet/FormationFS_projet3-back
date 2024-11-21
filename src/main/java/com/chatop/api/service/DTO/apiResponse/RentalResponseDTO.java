package com.chatop.api.service.DTO.apiResponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RentalResponseDTO {
    private Long id;

    private String name;

    private Double surface;

    private Double price;

    private String picture;

    private String description;

    private Long ownerId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date updatedAt;
}
