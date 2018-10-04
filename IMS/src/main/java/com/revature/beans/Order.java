package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	/*
	 * id itemid amount userid txid address
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order")
	@SequenceGenerator(name = "order", sequenceName = "order_seq", allocationSize = 1)
	private int id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="inventoryitem")
	private Item inventoryitem;
	@Column(name="amount")
	private int amount;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User user;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="transaction")
	private Txact tx;
	@Column(name = "address")
	private String address;

	public Order() {
		super();
	}
	public Order(int id, Item inventoryitem, int amount, User user, Txact tx, String address) {
		super();
		this.id = id;
		this.inventoryitem = inventoryitem;
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
	public Item getinventoryitem() {
		return inventoryitem;
	}
	public void setinventoryitem(Item inventoryitem) {
		this.inventoryitem = inventoryitem;
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
		result = prime * result + ((inventoryitem == null) ? 0 : inventoryitem.hashCode());
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
		if (inventoryitem == null) {
			if (other.inventoryitem != null)
				return false;
		} else if (!inventoryitem.equals(other.inventoryitem))
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
		return "Order [id=" + id + ", inventoryitem=" + inventoryitem + ", amount=" + amount + ", user=" + user + ", tx=" + tx
				+ ", address=" + address + "]";
	}
}