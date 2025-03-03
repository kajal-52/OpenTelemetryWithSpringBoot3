package com.price.demo.model;

public class Price {
	private String productId;
	private double priceAmount;
	private double discount;

	public double getPriceAmount() {
		return priceAmount;
	}

	public void setPriceAmount(double priceAmount) {
		this.priceAmount = priceAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}