package com.controller;

public class FindBidException extends RuntimeException{

	public FindBidException() {
		super("Bid is not avliable in database");
	}
	
	@Override
	public String toString() {
		return "Bid is not avliable in database";
	}
	
}
