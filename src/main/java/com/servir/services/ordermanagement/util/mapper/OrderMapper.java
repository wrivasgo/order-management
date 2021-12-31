package com.servir.services.ordermanagement.util.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.servir.services.ordermanagement.entity.Order;
import com.servir.services.ordermanagement.entity.Product;
import com.servir.services.ordermanagement.model.request.OrderRequest;
import com.servir.services.ordermanagement.model.response.ItemResponse;
import com.servir.services.ordermanagement.model.response.OrderResponse;
import com.servir.services.ordermanagement.util.constants.Constants;
import com.servir.services.ordermanagement.util.constants.StatusEnum;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, 
imports = {Date.class, SimpleDateFormat.class, Constants.class, StatusEnum.class})
public interface OrderMapper {
	
	double cantidad = 6;
	
	@Mapping(target = "date", expression = "java(new Date())")
	@Mapping(target = "status", expression = "java(StatusEnum.PENDING.getDescription())")
	Order orderRequestToOrder(OrderRequest orderRequest);
	
	@Mapping(target = "date", expression = "java(new SimpleDateFormat(Constants.DATE_FORMAT).format(order.getDate()))")
	OrderResponse orderToOrderResponse(Order order);
	
	@Mapping(target = "cost", expression = "java(product.getUnitPrice())")
	ItemResponse productToItemReponse (Product product);
}
