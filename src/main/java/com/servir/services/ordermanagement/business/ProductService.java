package com.servir.services.ordermanagement.business;

import com.servir.services.ordermanagement.model.request.ProductRequest;
import com.servir.services.ordermanagement.model.response.ProductResponse;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface ProductService {
	Single<ProductResponse> save(ProductRequest productRequest);
	Observable<ProductResponse> listProduct();
	Maybe<ProductResponse> update(ProductRequest productRequest);
	Completable deleteById(Long idProduct) ;
}
