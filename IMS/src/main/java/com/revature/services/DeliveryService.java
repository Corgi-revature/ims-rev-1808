package com.revature.services;

import java.util.List;
import java.util.Set;

import com.revature.beans.Delivery;

public interface DeliveryService {
	int addDelivery(Delivery deli);
	Delivery getDeliveryById(int id);
	List<Delivery> getDeliveriesCriteria(Delivery deli);
	Set<Delivery> getDeliveries();
	void updateDelivery(Delivery deli);
	void deleteDelivery(Delivery deli);
	void deleteDeliveryById(int id);
}
