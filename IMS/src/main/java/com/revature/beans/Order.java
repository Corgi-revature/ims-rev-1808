package com.revature.beans;

public class Order {
/*
 * id
 * itemid
 * amount
 * userid
 * txid
 * address
 */
	private int id;
	private Item item;
	private int amount;
	private User user;
	private Txact tx;
	private String address;
	public Order() {
		super();
	}
	public Order(int id, Item item, int amount, User user, Txact tx, String address) {
		super();
		this.id = id;
		this.item = item;
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
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
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
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
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
		return "Order [id=" + id + ", item=" + item + ", amount=" + amount + ", user=" + user + ", tx=" + tx
				+ ", address=" + address + "]";
	}
}
