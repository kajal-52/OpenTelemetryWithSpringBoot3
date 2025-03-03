package com.price.demo.exception;

public class PriceNotFoundException extends Exception {

	private String errorMsg;

	public PriceNotFoundException(String error) {
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
