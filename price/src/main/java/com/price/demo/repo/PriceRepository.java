package com.price.demo.repo;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.price.demo.exception.PriceNotFoundException;
import com.price.demo.model.Price;

@Repository
public class PriceRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(PriceRepository.class);

	HashMap<String, Price> priceMap = new HashMap<>();

	public PriceRepository() {
		Price price1 = new Price();
		price1.setProductId("198887");
		price1.setPriceAmount(1999.99);
		price1.setDiscount(20);
		Price price2 = new Price();
		price2.setProductId("208898");
		price2.setPriceAmount(2999.99);
		price2.setDiscount(19.0);
		priceMap.put("198887", price1);
		priceMap.put("208898", price2);

	}

	public Price getPrice(String productId) throws PriceNotFoundException {
		LOGGER.info("Getting Price from Price Repo With Product Id {}", productId);
		System.out.println(priceMap.get(productId));
		if (!priceMap.containsKey(productId)) {
			LOGGER.error("Price Not Found for Product Id {}", productId);
			throw new PriceNotFoundException("Price Not Found");
		}
		return priceMap.get(productId);
	}
}
