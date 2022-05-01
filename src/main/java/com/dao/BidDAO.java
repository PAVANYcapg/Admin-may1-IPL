package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Bid;
import com.model.Bidder;

@Repository

public interface BidDAO {

	public void addBid(Bid bid);
	public Bid findBid(int id);
	public List<Bid> findAllBid();
	public boolean updateBid(Bid bid);
	public boolean deleteBid(int id);
	
public double getBidderPercentage(Team team);
}
