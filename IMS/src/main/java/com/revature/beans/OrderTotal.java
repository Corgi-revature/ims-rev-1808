package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@NamedQueries({
})
public class OrderTotal {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Column(name = "address")
	private String address;
	@Column(name = "name")
	private String name;
	@Column(name = "amount")
	private String amount;
	@Column(name = "price")
	private double price;
	@Column(name = "total")
	private int total;
	@Column(name = "status")
	private String status;
	public OrderTotal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderTotal(int id, String address, String name, String amount, double price, int total, String status) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.total = total;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + total;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderTotal other = (OrderTotal) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (total != other.total)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderTotal [id=" + id + ", address=" + address + ", name=" + name + ", amount=" + amount + ", price="
				+ price + ", total=" + total + ", status=" + status + "]";
	}
	
}