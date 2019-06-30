package com.bookingboss.event.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bookingboss.event.entities.ApiResponseEntity;
import com.bookingboss.event.entities.ProductIdWrapper;



import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductsControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void Get() throws Exception {
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<ApiResponseEntity<List<ProductIdWrapper>>> response = restTemplate.exchange(
    	  "http://localhost:" + port + "/product/",
    	  HttpMethod.GET,
    	  null,
    	  new ParameterizedTypeReference<ApiResponseEntity<List<ProductIdWrapper>>>(){});
    	ApiResponseEntity<List<ProductIdWrapper>> prods = response.getBody();
        assertThat(prods.getProducts().size() == 5);
    }
}
