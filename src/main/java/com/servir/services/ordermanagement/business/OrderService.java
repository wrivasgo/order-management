package com.servir.services.ordermanagement.business;

import com.servir.services.ordermanagement.model.request.OrderRequest;
import com.servir.services.ordermanagement.model.response.OrderResponse;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface OrderService {
	Single<OrderResponse> manageOrder(OrderRequest orderRequest);
	Observable<OrderResponse> listOrders ();
	Maybe<OrderResponse> updateStatus(OrderRequest orderRequest);
	Completable deleteItemByIdProductAndIdOrder(Long idProduct, Long idOrder);
}
