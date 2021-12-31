package com.servir.services.ordermanagement.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemResponse {
	private Long id;
	private String name;
	private int quantity;
	private double unitPrice;
	private double cost;
}
