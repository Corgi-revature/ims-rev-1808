package com.revature.services;

import java.util.List;
import com.revature.beans.Delivery;

public interface DeliveryService {
	
	List<Delivery> getDeliveries();
	Delivery getDeliveryById(Integer id);
	Delivery getDeliveryCriteria();
	
	// Returns no value
	/*void createDelivery();
	void updateDelivery();	
	void deleteDelivery();*/
	
	// Returns value
	Integer createDelivery(Integer id);
	Integer updateDelivery(Integer id);	
	Integer deleteDelivery(Integer id);
	
}
