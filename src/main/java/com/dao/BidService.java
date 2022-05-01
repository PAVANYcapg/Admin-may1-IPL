package com.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Bid;
import com.model.Bidder;

@Service

public class BidService {
	@Autowired
	
	BidDAO bidDAOImpl;
	
	public void add(Bid bid) {
		bidDAOImpl.addBid(bid);
	}
	
	public Bid findBid(int id) {
		return bidDAOImpl.findBid(id);
	}
	
	public List<Bid> findAllBid() {
		return bidDAOImpl.findAllBid();
	}
	
	public boolean update(Bid bid) {
		return bidDAOImpl.updateBid(bid);
	}
	
	public boolean delete(int id) {
		return bidDAOImpl.deleteBid(id);
	}


}
