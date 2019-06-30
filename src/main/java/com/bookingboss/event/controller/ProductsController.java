package com.bookingboss.event.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


import com.bookingboss.event.ProductRepository;
import com.bookingboss.event.entities.ApiRequestEntity;
import com.bookingboss.event.entities.ApiResponseEntity;
import com.bookingboss.event.entities.ProductIdWrapper;
import com.bookingboss.event.model.Product;
import com.bookingboss.event.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/v1/products")
@Api(value = "Products", description = "REST API for Products", tags = {"Products"})
@Validated
public class ProductsController {
	ProductService productService;
	
	@Autowired
    public ProductsController(ProductService productService) {
	   this.productService = productService;
	}

	@ApiOperation(value = "Get all product IDs")
    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getIds() {
        List<ProductIdWrapper> ids = productService.getAllProductsIds();
        return ResponseEntity.ok().body(new ApiResponseEntity<>(ids));
    }

    @ApiOperation(value = "Post list of product value objects to insert")
    @RequestMapping(path = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity post(@RequestBody ApiRequestEntity<List<Product>> req) {
    	List<Product> products = productService.bulkUpdate(req.getProducts());
        return ResponseEntity.ok().body(new ApiResponseEntity<>(products));
    }

    @ApiOperation(value = "Get a product details")
    @RequestMapping(path = "/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOne(@PathVariable @Min(1) long productId) {
        Product products;
        products = productService.getProductById(productId);
        return ResponseEntity.ok().body(new ApiResponseEntity<>(Collections.singletonList(products)));
    }
}
