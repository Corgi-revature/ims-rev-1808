package com.revature.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="deliveries")
public class Delivery {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="deliveries")
	@SequenceGenerator(name="deliveries", sequenceName="delivery_seq", allocationSize=1)
	private int id;
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="inventoryitems",
		joinColumns=@JoinColumn(name="item"),
		inverseJoinColumns=@JoinColumn(name="id"))
	private Set<Item> items;
	private int amount;
	private String supplier;
	public Delivery() {
		super();
	}
	public Delivery(int id, Set<Item> items, String supplier) {
		super();
		this.id = id;
		this.items = items;
		this.supplier = supplier;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		return "Delivery [id=" + id + ", items=" + items + ", supplier=" + supplier + "]";
	}
}
