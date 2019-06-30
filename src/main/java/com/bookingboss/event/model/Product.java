package com.bookingboss.event.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Product {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private int quantity;
    
	@JsonProperty("sale_amount")
    private int saleAmount;
    
    protected   Product() {}
    
    public Product(Long id, String name, int quantity, int saleAmount) {
	
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.saleAmount = saleAmount;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}

	@Override
	public String toString() {
		return String.format("Product [id=%d, name=%s, quantity=%d, saleAmount=%d]", id, name, quantity, saleAmount);
	}
	
	
}

