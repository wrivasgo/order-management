package com.servir.services.expose.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servir.services.ordermanagement.business.ProductService;
import com.servir.services.ordermanagement.model.request.ProductRequest;
import com.servir.services.ordermanagement.model.response.ProductResponse;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<ProductResponse> saveProduct(@RequestBody ProductRequest productRequest) {
		return productService.save(productRequest);
	}
	
	
	@GetMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Observable<ProductResponse> listProduct() {
		return productService.listProduct();
	}
	
	@PutMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public Maybe<ProductResponse> update(@RequestBody ProductRequest productRequest) {
		return productService.update(productRequest);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/product/{id}")
	public Completable deleteById(@PathVariable Long id) {
		return productService.deleteById(id);
	}
}
