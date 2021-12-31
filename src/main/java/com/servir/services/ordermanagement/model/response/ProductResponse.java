package com.servir.services.ordermanagement.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponse {
	private Long id;
	private String name;
	private String category;
	private double unitPrice;
	private String status;
}
