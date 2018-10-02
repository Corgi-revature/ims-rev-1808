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
@Table(name="deliveries")
public class Delivery {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="deliveries")
	@SequenceGenerator(name="deliveries", sequenceName="delivery_seq", allocationSize=1)
	private int id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item")
	private Item items;
	@Column(name="amount")
	private int amount;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="supplier")
	private Supplier supplier;
	public Delivery() {
		super();
	}	
	
	public Delivery(int id, Item items, int amount, Supplier supplier) {
		super();
		this.id = id;
		this.items = items;
		this.amount = amount;
		this.supplier = supplier;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Item getItems() {
		return items;
	}


	public void setItems(Item items) {
		this.items = items;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + id;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
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
		Delivery other = (Delivery) obj;
		if (amount != other.amount)
			return false;
		if (id != other.id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Delivery [id=" + id + ", items=" + items + ", amount=" + amount + ", supplier=" + supplier + "]";
	}
	
}
