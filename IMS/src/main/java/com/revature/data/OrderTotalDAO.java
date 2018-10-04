package com.revature.data;

import java.util.List;
import java.util.Set;

import com.revature.beans.OrderTotal;

public interface OrderTotalDAO {
	public OrderTotal getOrdTotalById(int id);
	public Set<OrderTotal> getOrdTotals();
}
