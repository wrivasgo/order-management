package com.servir.services.ordermanagement.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servir.services.ordermanagement.business.ProductService;
import com.servir.services.ordermanagement.model.request.ProductRequest;
import com.servir.services.ordermanagement.model.response.ProductResponse;
import com.servir.services.ordermanagement.repository.ProductRepository;
import com.servir.services.ordermanagement.util.mapper.ProductMapper;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper productMapper; 

	@Override
	public Single<ProductResponse> save(ProductRequest productRequest) {
		return Single.just(productRepository.save(productMapper.productRequestToProduct(productRequest)))
				.map(product -> productMapper.productToProductResponse(product));
	}
	
	@Override
	public Observable<ProductResponse> listProduct(){
		return Observable.fromIterable(productRepository.findAll())
				.map(product -> productMapper.productToProductResponse(product));
	}
	
	@Override
	public Maybe<ProductResponse> update(ProductRequest productRequest) {
		return Maybe.just(productRepository.findById(productRequest.getId()).get())
				//.switchIfEmpty(Maybe.error(ExceptionEnum.ERROR001.getException()))
				.map( product -> {
					product.setName(productRequest.getName());
					product.setCategory(productRequest.getCategory());
					product.setUnitPrice(productRequest.getUnitPrice());
					product.setStatus(productRequest.getStatus());
					
					return productRepository.save(product);
				})
				.map(product -> productMapper.productToProductResponse(product));
	}
	
	@Override
	public Completable deleteById(Long idProduct) {
		return Maybe.just(productRepository.findById(idProduct).get())
				.doOnSuccess(product -> productRepository.deleteById(product.getId()))
				.ignoreElement();
	}
}
