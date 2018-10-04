package com.revature.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usertypes")
public class UserType {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usertype")
	@SequenceGenerator(name="usertype", sequenceName="usertype_seq")
	@Column(name = "id")
	private int id;
	@Column(name="typetext")
	private String usertype;
	public UserType() {
		super();
	}
	public UserType(int id, String usertype) {
		super();
		this.id = id;
		this.usertype = usertype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((usertype == null) ? 0 : usertype.hashCode());
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
		UserType other = (UserType) obj;
		if (id != other.id)
			return false;
		if (usertype == null) {
			if (other.usertype != null)
				return false;
		} else if (!usertype.equals(other.usertype))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserType [id=" + id + ", usertype=" + usertype + "]";
	}
}
