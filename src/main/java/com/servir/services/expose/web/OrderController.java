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

import com.servir.services.ordermanagement.business.OrderService;
import com.servir.services.ordermanagement.model.request.OrderRequest;
import com.servir.services.ordermanagement.model.response.OrderResponse;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<OrderResponse> manageOrder(@RequestBody OrderRequest orderRequest) {
		return orderService.manageOrder(orderRequest);
	}
	
	@GetMapping(value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Observable<OrderResponse> listProduct() {
		return orderService.listOrders();
	}
	
	@PutMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public Maybe<OrderResponse> updateStatus(@RequestBody OrderRequest orderRequest) {
		return orderService.updateStatus(orderRequest);
	}
		
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/order/idproduct/{idProduct}/idorder/{idOrder}")
	public Completable deleteItemByIdProductAndIdOrder(@PathVariable Long idProduct, @PathVariable Long idOrder) {
		return orderService.deleteItemByIdProductAndIdOrder(idProduct, idOrder);
	}
}
