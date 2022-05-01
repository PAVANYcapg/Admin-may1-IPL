package com.controller;

public class DeleteBidException extends RuntimeException {

	private int id;
	public DeleteBidException(int id) {
		super("id " + id + " not found");
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "id " + id + " is not avaliable";
	}
}
