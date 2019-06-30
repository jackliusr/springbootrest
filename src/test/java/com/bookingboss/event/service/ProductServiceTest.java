package com.bookingboss.event.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import com.bookingboss.event.ProductRepository;

public class ProductServiceTest {
	 private ProductRepository repo = Mockito.mock(ProductRepository.class);;

	 private ProductService service;
	 
	 @BeforeEach
	 void setup() {
		 service = new ProductService(repo);
	 }
	 @Test
	public void test() {
		// service.
	}

}
