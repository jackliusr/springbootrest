package com.bookingboss.event.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Wrapper on id for api response
 */
public class ProductIdWrapper {
    long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProductIdWrapper(long id) {
		super();
		this.id = id;
	}
}
