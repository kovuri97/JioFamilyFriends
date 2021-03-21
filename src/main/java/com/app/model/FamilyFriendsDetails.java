package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FamilyFriendsDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int familyOrFriendId;
	private int customerId;
	private String personName;
	private String relation;
	private long phoneNumber;
	public int getFamilyOrFriendId() {
		return familyOrFriendId;
	}
	public void setFamilyOrFriendId(int familyOrFriendId) {
		this.familyOrFriendId = familyOrFriendId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
