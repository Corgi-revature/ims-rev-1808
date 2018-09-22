package com.revature.beans;

import java.sql.Date;

public class Txact {
	private int id;
	private Date created;
	private String token;
	private String txid;
	public Txact() {
		super();
	}
	public Txact(int id, Date created, String token, String txid) {
		super();
		this.id = id;
		this.created = created;
		this.token = token;
		this.txid = txid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + id;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((txid == null) ? 0 : txid.hashCode());
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
		Txact other = (Txact) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id != other.id)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (txid == null) {
			if (other.txid != null)
				return false;
		} else if (!txid.equals(other.txid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Txact [id=" + id + ", created=" + created + ", token=" + token + ", txid=" + txid + "]";
	}
}
