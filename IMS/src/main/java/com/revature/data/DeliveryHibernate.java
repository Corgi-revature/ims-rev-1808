package com.revature.data;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Delivery;
import com.revature.utils.HibernateUtil;

@Component
public class DeliveryHibernate implements DeliveryDAO {
	@Autowired
	private HibernateUtil hu;
	
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
