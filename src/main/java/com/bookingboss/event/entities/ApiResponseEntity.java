package com.bookingboss.event.entities;

import java.time.ZoneId;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ApiResponseEntity<T> {

    private String id;
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

	private String timestamp;
    private T products;

    public ApiResponseEntity(T products){
        this.products = products;
        this.id = UUID.randomUUID().toString();
        this.timestamp = java.time.LocalDateTime.now(ZoneId.of("GMT")).toString();
    }
}
