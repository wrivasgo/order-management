package com.servir.services.ordermanagement.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servir.services.ordermanagement.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM product "
			+ "WHERE id_product = :idProduct and id_order = :idOrder",nativeQuery = true)
	void deleteProductByIdProductAndIdOrder(@Param("idProduct") Long IdProduct, 
											@Param("idOrder") Long idOrder);
}
