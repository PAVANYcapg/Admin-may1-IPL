package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Bid;

@Component

public   class BidDAOImpl implements BidDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addBid(Bid bid) {
		// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(bid);
			session.flush();
			session.getTransaction().commit();
			session.close();
		
	}

	@Override
	public Bid findBid(int id) {
			Session session = sessionFactory.openSession();
			Bid bidder = session.get(Bid.class, id); 
			return bidder;
	}
	@Override
	public List<Bid> findAllBid() {
		// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			List<Bid> bidder=session.createQuery("select i from Bid i").list();
			return bidder;
	}

	@Override
	public boolean updateBid(Bid team) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(team);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteBid(int id) {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			Bid bidder=session.find(Bid.class,id);
			session.delete(bidder);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
	}
	@Override
public double getBidderPercentage(Team team) {
	
	Session session = sessionFactory.openSession();
	 Query query=session.createQuery("select i from Bid i where i.team=:team");
query.setParameter("team", team);
List<Bid> bidlist=query.list();
int tSize=bidlist.size();
int totalSize=findAllBid().size();
return (tSize*100)/totalSize;

}
	

}
