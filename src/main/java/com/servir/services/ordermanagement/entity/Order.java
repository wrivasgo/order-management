package com.servir.services.ordermanagement.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ORDER", nullable = false)
	private Long id;
	
	@Column(name = "ORDER_NUMBER")
	private int orderNumber;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "CUSTOMER")
	private String customer;
	
	@Column(name = "TAX_AMOUNT")
	private BigDecimal taxAmount;
	
	@Column(name = "TOTAL_TAX")
	private BigDecimal totaltax;
	
	@Column(name = "TOTAL_AMOUNT")
	private BigDecimal totalAmount;

	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ORDER", referencedColumnName = "ID_ORDER")
	private List<Product> listOrderedItem;
}
