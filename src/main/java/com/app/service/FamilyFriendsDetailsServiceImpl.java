package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.FamilyFriendsDetails;
import com.app.repo.FamilyFriendsDetailsRepo;

@Service
public class FamilyFriendsDetailsServiceImpl implements FamilyFriendsDetailsService{
	@Autowired
	private FamilyFriendsDetailsRepo familyFriendsDetailsRepo;

	@Override
	public void addDetails(FamilyFriendsDetails familyFriendsDetails) {
		// TODO Auto-generated method stub
		familyFriendsDetailsRepo.save(familyFriendsDetails);
	}

	@Override
	public void updateDetails(FamilyFriendsDetails familyFriendsDetails) {
		// TODO Auto-generated method stub
		familyFriendsDetailsRepo.save(familyFriendsDetails);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		familyFriendsDetailsRepo.deleteById(id);
	}

	@Override
	public List<FamilyFriendsDetails> getFamilyFriendsDetails() {
		// TODO Auto-generated method stub
		return familyFriendsDetailsRepo.findAll();
	}

}
