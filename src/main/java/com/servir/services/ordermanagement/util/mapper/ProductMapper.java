package com.servir.services.ordermanagement.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.servir.services.ordermanagement.entity.Product;
import com.servir.services.ordermanagement.model.request.ProductRequest;
import com.servir.services.ordermanagement.model.response.ProductResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
	
	Product productRequestToProduct(ProductRequest productRequest);
	
	ProductResponse productToProductResponse(Product product);
}
