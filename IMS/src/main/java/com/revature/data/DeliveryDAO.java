package com.revature.data;

import java.util.Set;

import com.revature.beans.Delivery;

public interface DeliveryDAO extends HibernateSession {
<<<<<<< HEAD
	public Delivery addDelivery(Delivery deli);
=======
	public int addDelivery(Delivery deli);
>>>>>>> 9e67316221ca644f9f6176b9c1d2f56a4eb11ba7
	public Delivery getDeliveryById(int id);
	public Set<Delivery> getDeliveriesCriteria();
	public Set<Delivery> getDeliveries();
	public void updateDelivery(Delivery deli);
	public void deleteDelivery(Delivery deli);
	public void deleteDeliveryById(int id);
	
}
