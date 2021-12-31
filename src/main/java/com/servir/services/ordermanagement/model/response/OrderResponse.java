package com.servir.services.ordermanagement.model.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderResponse {
	private Long id;
	private int orderNumber;
	private String status;
	private String date;
	private String customer;
	private BigDecimal taxAmount;
	private BigDecimal totaltax;
	private BigDecimal totalAmount;
	private List<ItemResponse> listOrderedItem;
}
