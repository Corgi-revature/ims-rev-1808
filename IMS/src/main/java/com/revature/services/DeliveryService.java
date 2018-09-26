package com.revature.services;

import java.util.List;
import com.revature.beans.Delivery;

public interface DeliveryService {
	
	List<Delivery> getAllDeliveries();
	Delivery getDeliveryById(Integer id);
	Delivery getDeliveryByCriteria();
	
	// Returns no value
	/*void createDelivery();
	void updateDelivery();	
	void deleteDelivery();*/
	
	// Returns value
	Integer createDelivery(Integer id);
	Integer updateDelivery(Integer id);	
	Integer deleteDelivery(Integer id);
	
}
