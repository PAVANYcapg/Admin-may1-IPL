package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.BidService;
import com.model.Admin;
import com.model.Bid;
import com.model.Bidder;

@RestController

public class BidController {
	
	@Autowired
	BidService bidService;
	
	
	@PostMapping("/addBid")
	public ResponseEntity<?> addBid(@RequestBody Bid bid){
		bidService.add(bid);
		return ResponseEntity.status(HttpStatus.OK).body("Bid added succesfully");
	}
	
	@DeleteMapping("/deleteBid/{id}")
	public ResponseEntity<?> deleteBid(@PathVariable int id) throws DeleteBidException {
		Bid bid = bidService.findBid(id);
		if(bidService==null) {
			throw new DeleteBidException(id);
		}
		bidService.delete(id);
		return ResponseEntity.ok("Bid deleted succesfully");
	}
	
	
	@PatchMapping("/updateBid")
	public ResponseEntity<?> updateBid(@RequestBody Bid bid) throws UpdateBidException{
		Bid Bid1=bidService.findBid(bid.getBidId());
		if(Bid1==null) {
			throw new UpdateBidException();
		}
		bidService.update(bid);
		return ResponseEntity.ok("Bid updated succesfully");
	}
	
	@GetMapping("/findBid/{id}")
	public ResponseEntity<?> findBid(@PathVariable int id)throws FindBidException{
		
		Bid Bid2=bidService.findBid(id);
		if(Bid2==null) {
			throw new FindBidException
			
			();
		}
		bidService.findBid(id);
		return ResponseEntity.ok("element find succesfully");
	}
	
	@GetMapping("/findallBid")
	public List<Bid> findAllBid(){
		return bidService.findAllBid();	
	}

}
