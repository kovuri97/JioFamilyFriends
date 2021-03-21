package com.app.service;

import java.util.List;

import com.app.model.FamilyFriendsDetails;

public interface FamilyFriendsDetailsService {
	
	public void addDetails(FamilyFriendsDetails familyFriendsDetails);
	public void updateDetails(FamilyFriendsDetails familyFriendsDetails);
	public void delete(int id);
	public List<FamilyFriendsDetails> getFamilyFriendsDetails();
}
