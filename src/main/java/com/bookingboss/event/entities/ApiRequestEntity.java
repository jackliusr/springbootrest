package com.bookingboss.event.entities;

import java.time.ZoneId;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

public class ApiRequestEntity<T> {

    private String id;
    private String timestamp;
    private T products;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public T getProducts() {
		return products;
	}

	public void setProducts(T products) {
		this.products = products;
	}

	public ApiRequestEntity(String id, String timestamp, T products) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.products = products;
	}
   
}
