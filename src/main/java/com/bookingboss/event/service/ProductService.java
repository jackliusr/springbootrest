package com.bookingboss.event.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingboss.event.ProductRepository;
import com.bookingboss.event.entities.ProductIdWrapper;
import com.bookingboss.event.model.Product;


@Service
public class ProductService {

	
	private ProductRepository repo; 
	
	
	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
	}

	public List<ProductIdWrapper> getAllProductsIds() {

		ArrayList<Long> ids = new ArrayList<>(repo.getAllId());
		return ids
		.stream()
		.map(p ->new ProductIdWrapper(p) )
		.collect(Collectors.toList());
	}

	public List<Product> bulkUpdate(List<Product> products) {
		repo.saveAll(products);
		return products;
	}

	public Product getProductById(@Min(1) long productId) {
		// TODO Auto-generated method stub
		Optional<Product> p =repo.findById(productId);
		if(p.isPresent()) return p.get();
		return null;
	}

}
