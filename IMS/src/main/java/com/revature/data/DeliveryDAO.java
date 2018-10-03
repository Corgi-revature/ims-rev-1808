package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.Delivery;

public interface DeliveryDAO {
	public int addDelivery(Delivery deli);
	public Delivery getDeliveryById(int id);
	public List<Delivery> getDeliveriesCriteria(Delivery deli);
	public Set<Delivery> getDeliveries();
	public void updateDelivery(Delivery deli);
	public void deleteDelivery(Delivery deli);
	public void deleteDeliveryById(int id);
	
}
