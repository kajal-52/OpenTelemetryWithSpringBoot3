package com.product.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.exception.ProductNotFoundException;
import com.product.demo.model.Product;
import com.product.demo.repo.PriceClient;
import com.product.demo.repo.ProductRepository;

@RestController
@RequestMapping("/api/")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private PriceClient priceClient;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping(path = "product/{id}")
	public Product getProductDetails(@PathVariable("id") String productId) throws ProductNotFoundException {
		LOGGER.info("Getting Product and Price Details with Product Id {}", productId);
		System.out.println(productId);
		Product product = productRepository.getProduct(productId);
		product.setPrice(priceClient.getPrice(productId).getPriceAmount());
		return product;
	}

}