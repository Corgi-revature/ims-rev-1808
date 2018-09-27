package com.revature.data;

import java.util.Set;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Delivery;

@Component
public class DeliveryHibernate implements DeliveryDAO {
	private Session session;
	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public Delivery addDelivery(Delivery deli) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Delivery getDeliveryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Delivery> getDeliveriesCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Delivery> getDeliveries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDelivery(Delivery deli) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDelivery(Delivery deli) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDeliveryById(int id) {
		// TODO Auto-generated method stub
		
	}

}
