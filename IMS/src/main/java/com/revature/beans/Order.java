package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
/*
 * id
 * itemid
 * amount
 * userid
 * txid
 * address
 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order")
	@SequenceGenerator(name="order", sequenceName="order_seq", allocationSize=1)
	private int id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="inventoryitem")
	private Inventory inventory;
	@Column(name="amount")
	private int amount;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private User user;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="transaction")
	private Txact tx;
	@Column(name="address")
	private String address;
	public Order() {
		super();
	}
	public Order(int id, Inventory inventory, int amount, User user, Txact tx, String address) {
		super();
		this.id = id;
		this.inventory = inventory;
		this.amount = amount;
		this.user = user;
		this.tx = tx;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Txact getTx() {
		return tx;
	}
	public void setTx(Txact tx) {
		this.tx = tx;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + amount;
		result = prime * result + id;
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		result = prime * result + ((tx == null) ? 0 : tx.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (amount != other.amount)
			return false;
		if (id != other.id)
			return false;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		if (tx == null) {
			if (other.tx != null)
				return false;
		} else if (!tx.equals(other.tx))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", inventory=" + inventory + ", amount=" + amount + ", user=" + user + ", tx=" + tx
				+ ", address=" + address + "]";
	}
}
