package com.servir.services.ordermanagement.model.request;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequest {
	private Long id;
	private int orderNumber;
	private String status;
//	private Date date;
	private String customer;
	private BigDecimal taxAmount;
	private BigDecimal totaltax;
	private BigDecimal totalAmount;
	private List<ProductRequest> listOrderedItem;
}
