package com.revature.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Delivery;
import com.revature.data.DeliveryDAO;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	@Autowired
	private DeliveryDAO ds;
	
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
		return null;
	}

	@Override
	public Set<Delivery> getDeliveries() {
		return null;
	}

	@Override
	public void updateDelivery(Delivery deli) {
	
	}

	@Override
	public void deleteDelivery(Delivery deli) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDeliveryById(int id) {

	}
}
