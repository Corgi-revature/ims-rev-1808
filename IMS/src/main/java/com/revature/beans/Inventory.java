package com.revature.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="inventory")
	@SequenceGenerator(name="inventory", sequenceName="invent_seq", allocationSize=1)
	private int id;
	@JoinColumn(name="id")
	private Item item;
	private Date packagedate;
	private Date useby;
	private int stock;
	public Inventory() {
		super();
	}
	public Inventory(int id, Item item, Date packagedate, Date useby, int stock) {
		super();
		this.id = id;
		this.item = item;
		this.packagedate = packagedate;
		this.useby = useby;
		this.stock = stock;
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
	public Date getPackagedate() {
		return packagedate;
	}
	public void setPackagedate(Date packagedate) {
		this.packagedate = packagedate;
	}
	public Date getUseby() {
		return useby;
	}
	public void setUseby(Date useby) {
		this.useby = useby;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((packagedate == null) ? 0 : packagedate.hashCode());
		result = prime * result + stock;
		result = prime * result + ((useby == null) ? 0 : useby.hashCode());
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
		Inventory other = (Inventory) obj;
		if (id != other.id)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (packagedate == null) {
			if (other.packagedate != null)
				return false;
		} else if (!packagedate.equals(other.packagedate))
			return false;
		if (stock != other.stock)
			return false;
		if (useby == null) {
			if (other.useby != null)
				return false;
		} else if (!useby.equals(other.useby))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", item=" + item + ", packagedate=" + packagedate + ", useby=" + useby
				+ ", stock=" + stock + "]";
	}
}
