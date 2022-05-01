package com.controller;

public class UpdateBidException extends RuntimeException{

	public UpdateBidException() {
		
		super("Bid is not avliable in database to update");
	}
	
	@Override
	public String toString() {
		return "Bid is not avliable in database to update";
	}
	
}
