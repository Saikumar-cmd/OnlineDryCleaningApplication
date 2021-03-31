package com.cg.drycleaning.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private String userId;

	public Admin() {
		super();
	}

	public Admin(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Admin [userId=" + userId + "]";
	}

}
