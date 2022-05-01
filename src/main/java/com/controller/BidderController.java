package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.BidderService;
import com.model.Bidder;


@RestController
public class BidderController {

	@Autowired
	BidderService bidderService;
	
	@PostMapping("/addBidder")
	public ResponseEntity<?> addBidder(@RequestBody Bidder bidder) {
		bidderService.add(bidder);
		return ResponseEntity.status(HttpStatus.OK).body("Bidder added succesfully");
	}
	
	
	@DeleteMapping("/deleteBidder/{id}")
	public ResponseEntity<?> deleteBidder(@PathVariable int id) throws DeleteBidderException {
		Bidder bidder = bidderService.findTeam(id);
		if(bidderService==null) {
			throw new DeleteBidderException(id);
		}
		bidderService.delete(id);
		return ResponseEntity.ok("Bidder deleted succesfully");
	}
	
	
	@PatchMapping("/updateBidder")
	public ResponseEntity<?> updateBidder(@RequestBody Bidder bidder) throws UpdateBidderException{
		Bidder Bidder1=bidderService.findTeam(bidder.getBidderId());
		if(Bidder1==null) {
			throw new UpdateBidderException();
		}
		bidderService.update(bidder);
		return ResponseEntity.ok("Bidder updated succesfully");
	}
	
	@GetMapping("/findBidder/{id}")
	public ResponseEntity<?> findBidder(@PathVariable int id)throws FindAllBidderException{
		
		Bidder Bidder2=bidderService.findTeam(id);
		if(Bidder2==null) {
			throw new FindAllBidderException
			
			();
		}
		bidderService.findTeam(id);
		return ResponseEntity.ok("element find succesfully");
	}
	
	@GetMapping("/findallBidder")
	public List<Bidder> findAllTeam(){
		return bidderService.findAllTeam();	
	}
}
