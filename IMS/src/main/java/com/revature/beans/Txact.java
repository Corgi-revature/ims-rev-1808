package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Txact {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="txact")
	@SequenceGenerator(name="txact", sequenceName="tx_seq", allocationSize=1)
	private int id;
	@Column(name="created")
	private String created;
	@Column(name="token")
	private String token;
	@Column(name="txid")
	private String txid;
	@Column(name="status")
	private String status;
	
	public Txact() {
		super();
	}
	public Txact(int id, String created, String token, String txid, String status) {
		super();
		this.id = id;
		this.created = created;
		this.token = token;
		this.txid = txid;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		return "Txact [id=" + id + ", created=" + created + ", token=" + token + ", txid=" + txid + ", status=" + status
				+ "]";
	}
}
