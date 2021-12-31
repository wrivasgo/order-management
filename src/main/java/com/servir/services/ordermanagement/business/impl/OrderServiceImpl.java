package com.servir.services.ordermanagement.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servir.services.ordermanagement.business.OrderService;
import com.servir.services.ordermanagement.model.request.OrderRequest;
import com.servir.services.ordermanagement.model.response.OrderResponse;
import com.servir.services.ordermanagement.repository.OrderRepository;
import com.servir.services.ordermanagement.repository.ProductRepository;
import com.servir.services.ordermanagement.util.mapper.OrderMapper;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderMapper orderMapper;

	@Override
	public Single<OrderResponse> manageOrder(OrderRequest orderRequest) {
		return Single.just(orderRepository.save(orderMapper.orderRequestToOrder(orderRequest)))
				.map(order -> orderMapper.orderToOrderResponse(order));
	}

	@Override
	public Observable<OrderResponse> listOrders() {
		return Observable.fromIterable(orderRepository.findAll())
				.map(order -> orderMapper.orderToOrderResponse(order));
	}

	@Override
	public Maybe<OrderResponse> updateStatus(OrderRequest orderRequest) {
		return Maybe.just(orderRepository.findById(orderRequest.getId()).get())
				// .switchIfEmpty(Maybe.error(ExceptionEnum.ERROR001.getException()))
				.map(order -> {
					order.setStatus(orderRequest.getStatus());
					
					return orderRepository.save(order);
				}).map(order -> orderMapper.orderToOrderResponse(order));
	}

	@Override
	public Completable deleteItemByIdProductAndIdOrder(Long idProduct, Long idOrder) {
		return Maybe.just(orderRepository.findById(idOrder).get())
				.doOnSuccess(order -> productRepository.deleteProductByIdProductAndIdOrder(idProduct, order.getId()))
				.ignoreElement();
	}

}
