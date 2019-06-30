package com.bookingboss.event;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bookingboss.event.model.Product;
public interface ProductRepository extends CrudRepository<Product, Long> {
	  List<Product> findByName(String name);
	 
	  @Query(value = "SELECT p.id FROM Product p")
	  List<Long> getAllId();
}
