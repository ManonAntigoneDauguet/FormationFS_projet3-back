package com.chatop.api.model.apiResponse;

import lombok.Data;

@Data
public class ApiTokenResponse implements ApiResponse {

	private String token;
	
    public ApiTokenResponse(String token) {
        this.token = token;
    }
}
