package com.kh.petner.market.model.exception;

public class MarketException extends Exception{
		//예외 발생시 화면에 정해진 문장을 띄워주기 위하여 사용한다.
	
	public MarketException() {
		
	}
	
	public MarketException(String message) {
		super(message);
	}
	
}
