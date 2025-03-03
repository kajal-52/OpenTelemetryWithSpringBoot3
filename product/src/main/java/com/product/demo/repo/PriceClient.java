package com.product.demo.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.price.demo.model.Price;

@Component
public class PriceClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(PriceClient.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${baseurl}")
	private String baseUrl;

	public Price getPrice(@PathVariable("id") String productId) {
		LOGGER.info("Fetching Price Details With Product Id {}", productId);
		String url = String.format("%s/price/%s", baseUrl, productId);
		ResponseEntity<Price> price = restTemplate.getForEntity(url, Price.class);
		return price.getBody();
	}
}
