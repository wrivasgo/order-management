package com.servir.services.ordermanagement.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequest {
	private Long id;
	private String name;
	private String category;
	private double unitPrice;
	private String status;
}
