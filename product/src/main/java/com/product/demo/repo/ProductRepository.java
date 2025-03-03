package com.product.demo.repo;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.product.demo.exception.ProductNotFoundException;
import com.product.demo.model.Product;

@Repository
public class ProductRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepository.class);

	HashMap<String, Product> productMap = new HashMap<>();

	public ProductRepository() {
		Product product1 = new Product();
		product1.setName("Watch");
		product1.setId("198887");
		productMap.put("198887", product1);
		Product product2 = new Product();
		product2.setName("Water Bottle");
		product2.setId("208898");
		productMap.put("208898", product2);
	}

	public Product getProduct(String productId) throws ProductNotFoundException {
		LOGGER.info("Getting Product from Product Repo With Product Id {}", productId);
		System.out.println(productId + ":" + productMap.get(productId));
		if (!productMap.containsKey(productId)) {
			LOGGER.error("Product Not Found for Product Id {}", productId);
			throw new ProductNotFoundException("Product Not Found");
		}
		return productMap.get(productId);
	}

}
