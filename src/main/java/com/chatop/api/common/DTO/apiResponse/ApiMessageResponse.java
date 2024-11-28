package com.chatop.api.common.DTO.apiResponse;

import lombok.Data;

@Data
public class ApiMessageResponse {

	private String message;
	
    public ApiMessageResponse(String message) {
        this.message = message;
    }
}
