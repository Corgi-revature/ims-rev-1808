package com.revature.services;

import java.util.Set;

import com.revature.beans.Delivery;

public interface DeliveryService {

	Delivery addDelivery(Delivery deli);
	Delivery getDeliveryById(int id);
	Set<Delivery> getDeliverysCriteria();
	Set<Delivery> getDeliverys();
	void updateDelivery(Delivery deli);
	void deleteDelivery(Delivery deli);
	void deleteDeliveryById(int id);
}
