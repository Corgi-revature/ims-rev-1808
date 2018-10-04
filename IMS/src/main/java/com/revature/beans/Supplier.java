package com.revature.beans;

import javax.persistence.CascadeType;
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
@Table(name="suppliers")
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="suppliergen")
	@SequenceGenerator(name="suppliergen", sequenceName="supplier_seq", allocationSize=1)
	@Column(name="id")
	private int id;
	@Column(name="suppliername")
	private String name;
	@Column(name="email")
	private String email;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "itemsup")
	private Item itemsup;
	
	public Supplier() {
		super();
	}
	

	public Supplier(int id, String name, String email, Item itemsup) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.itemsup = itemsup;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Item getItemsup() {
		return itemsup;
	}

	public void setItemsup(Item itemsup) {
		this.itemsup = itemsup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((itemsup == null) ? 0 : itemsup.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Supplier other = (Supplier) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (itemsup == null) {
			if (other.itemsup != null)
				return false;
		} else if (!itemsup.equals(other.itemsup))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", email=" + email + ", itemsup=" + itemsup + "]";
	}
	
	
}
