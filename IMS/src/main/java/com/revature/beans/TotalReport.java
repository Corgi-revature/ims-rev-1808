package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class TotalReport {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	@Column(name = "totalvolume")
	private int totalVolume;
	@Column(name = "totalorder")
	private int totalOrder;
	@Column(name = "totalsales")
	private double totalSales;
	public TotalReport() {
		super();
	}
	public TotalReport(int id, int totalVolume, int totalOrder, double totalSales) {
		super();
		this.id = id;
		this.totalVolume = totalVolume;
		this.totalOrder = totalOrder;
		this.totalSales = totalSales;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalVolume() {
		return totalVolume;
	}
	public void setTotalVolume(int totalVolume) {
		this.totalVolume = totalVolume;
	}
	public int getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(int totalOrder) {
		this.totalOrder = totalOrder;
	}
	public double gettotalSales() {
		return totalSales;
	}
	public void settotalSales(double totalSales) {
		this.totalSales = totalSales;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(totalSales);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + totalOrder;
		result = prime * result + totalVolume;
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
		TotalReport other = (TotalReport) obj;
		if (Double.doubleToLongBits(totalSales) != Double.doubleToLongBits(other.totalSales))
			return false;
		if (id != other.id)
			return false;
		if (totalOrder != other.totalOrder)
			return false;
		if (totalVolume != other.totalVolume)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TotalReport [id=" + id + ", totalVolume=" + totalVolume + ", totalOrder=" + totalOrder + ", totalSales="
				+ totalSales + "]";
	}
}