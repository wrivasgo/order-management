package com.servir.services.ordermanagement.util.exception;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
	
	ERROR001("ERROR001", "No Existe el producto");
	
	private String code;
	private String description;
	
	private ExceptionEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public ApiException getException() {
		
		ApiException exception = new ApiException(code, description);
		return exception;
	}
	
}
