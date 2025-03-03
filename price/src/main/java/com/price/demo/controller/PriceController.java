package com.price.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.price.demo.exception.PriceNotFoundException;
import com.price.demo.model.Price;
import com.price.demo.repo.PriceRepository;

@RestController
@RequestMapping("/api/")
public class PriceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

	@Autowired
	private PriceRepository priceRepository;

	@GetMapping(path = "/price/{id}")
	public Price getPrice(@PathVariable("id") String productId) {
		LOGGER.info("Getting Price details for Product Id {}", productId);
		Price price = null;
		try {
			price = priceRepository.getPrice(productId);
		} catch (PriceNotFoundException e) {
			LOGGER.info("Error occurred in getting Price details for Product Id {}", productId);
		}
		return price;
	}
}