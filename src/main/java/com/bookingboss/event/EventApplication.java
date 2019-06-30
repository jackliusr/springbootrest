package com.bookingboss.event;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.bookingboss.event.model.Product;

@SpringBootApplication

public class EventApplication {
	private static final Logger log = LoggerFactory.getLogger(EventApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
		String timestmap = java.time.LocalDateTime.now(ZoneId.of("GMT")).toString();
		//System.out.println("timestampe:" + timestmap);
	}
 
	@Bean
	public CommandLineRunner demo(ProductRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Product(1L,"iPhone", 100,10));
			repository.save(new Product(2L,"iPad", 200,20));
			repository.save(new Product(3L,"Lenovo T470S", 300,30));
			repository.save(new Product(4L,"MacBook Pro", 400,40));
			repository.save(new Product(5L,"MacAir", 500,50));

			// fetch all products
			log.info("Products found with findAll():");
			log.info("-------------------------------");
			for (Product product : repository.findAll()) {
				log.info(product.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(product -> {
					log.info("Product found with findById(1L):");
					log.info("--------------------------------");
					log.info(product.toString());
					log.info("");
				});

			// fetch product by Name
			log.info("product found with findByName(iPad):");
			log.info("--------------------------------------------");
			repository.findByName("iPad").forEach(prod -> {
				log.info(prod.toString());
			});
		
			log.info("");
		};
	}
}
