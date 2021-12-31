package com.servir.services.ordermanagement.util.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;


@Getter
@JsonInclude(Include.NON_NULL)
public class ApiException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty
	private final String code;
	
	@JsonProperty
	private final String description;
	
//	@JsonProperty
//	private final String errorType;

	@JsonCreator
	public ApiException(
			@JsonProperty(value = "code", required = true) String code,
			@JsonProperty(value = "description", required = true) String description
			/** @JsonProperty(value = "errorType", required = true) String errorType*/) {
		super();
		this.code = code;
		this.description = description;
//		this.errorType = errorType;
	}
	
}
