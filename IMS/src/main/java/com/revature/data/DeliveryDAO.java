package com.revature.data;

import java.util.Set;

import com.revature.beans.Delivery;

public interface DeliveryDAO {
	public Delivery addDelivery(Delivery deli);
	public Delivery getDeliveryById(int id);
	public Set<Delivery> getDeliveriesCriteria();
	public Set<Delivery> getDeliveries();
	public void updateDelivery(Delivery deli);
	public void deleteDelivery(Delivery deli);
	public void deleteDeliveryById(int id);
	
}
