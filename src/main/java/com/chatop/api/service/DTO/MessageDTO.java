package com.chatop.api.service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class MessageDTO {
	
	@NotNull(message = "rental_id is required")
	@Positive(message = "rental_id must be a positive number")
	private Long rental_id;
	
	@NotNull(message = "user_id is required")
	@Positive(message = "rental_id must be a positive number")
	private Long user_id;

	@NotBlank(message = "Message is required")
	private String message;
}
