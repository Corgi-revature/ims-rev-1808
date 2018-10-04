package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Delivery;
import com.revature.data.DeliveryDAO;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	@Autowired
	private DeliveryDAO dd;
	
	@Override
	public int addDelivery(Delivery deli) {
		int result = dd.addDelivery(deli);
		return result;
	}

	@Override
	public Delivery getDeliveryById(int id) {
		return dd.getDeliveryById(id);
	}

	@Override
	public List<Delivery> getDeliveriesCriteria(Delivery deli) {
		return dd.getDeliveriesCriteria(deli);
	}

	@Override
	public Set<Delivery> getDeliveries() {
		return dd.getDeliveries();
	}

	@Override
	public void updateDelivery(Delivery deli) {
		dd.updateDelivery(deli);
	}

	@Override
	public void deleteDelivery(Delivery deli) {
		dd.deleteDelivery(deli);
		
	}

	@Override
	public void deleteDeliveryById(int id) {
		dd.deleteDeliveryById(id);
	}
}
