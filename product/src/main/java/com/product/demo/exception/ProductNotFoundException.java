package com.product.demo.exception;

public class ProductNotFoundException extends Exception {

	private String errorMsg;

	public ProductNotFoundException(String error) {
		// TODO Auto-generated constructor stub
		this.setErrorMsg(error);
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	private static final long serialVersionUID = 1L;

}
