package com.servir.services.ordermanagement.util.constants;

import lombok.Getter;

@Getter
public enum StatusEnum {

	PENDING("E001", "Pending"),
	COMPLETED("E002", "Completed"),
	REJECTED("E003","Rejected");
	
	private String code;
	private String description;
	
	StatusEnum(String code, String description){
		this.code = code;
		this.description = description;
	}
}
