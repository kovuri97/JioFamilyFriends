package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.FamilyFriendsDetails;
import com.app.service.FamilyFriendsDetailsService;

@RestController
@RequestMapping("/FamilyFriends")
public class FamilyFriendsDetailsController {
	@Autowired
	private FamilyFriendsDetailsService familyFriendsDetailsService;

	@PostMapping("/addDetails")
	public ResponseEntity<?> addDetails(@RequestBody FamilyFriendsDetails familyFriendsDetails){
		List<FamilyFriendsDetails> details = familyFriendsDetailsService.getFamilyFriendsDetails();
		for(FamilyFriendsDetails vlaue : details ) {
			if(vlaue.getPhoneNumber()==familyFriendsDetails.getPhoneNumber()) {
				return ResponseEntity.ok().body("Family or Friend number is already available, cann't create new instance");
			}
			else if(vlaue.getPersonName().equalsIgnoreCase(familyFriendsDetails.getPersonName()))
			{
				return ResponseEntity.ok().body("Family or Friend name is already available, cann't create new instance");
			}
		}
		familyFriendsDetailsService.addDetails(familyFriendsDetails);
		return ResponseEntity.ok().body(familyFriendsDetails);
	}

	@PutMapping("/updateDetails")
	public ResponseEntity<?> updateDetails(@RequestBody FamilyFriendsDetails familyFriendsDetails){
		int check=0;
		List<FamilyFriendsDetails> details = familyFriendsDetailsService.getFamilyFriendsDetails();
		if(details.size()!=0) {
			for(FamilyFriendsDetails inputValidation : details) {
				if(inputValidation.getFamilyOrFriendId()!=familyFriendsDetails.getFamilyOrFriendId() &&
						( inputValidation.getPersonName().equalsIgnoreCase(familyFriendsDetails.getPersonName()) || inputValidation.getPhoneNumber()==familyFriendsDetails.getPhoneNumber())) {
					return ResponseEntity.ok().body("Entered family or friend details name/number are already assigned to another family/friend");
				}
				if(inputValidation.getFamilyOrFriendId()==familyFriendsDetails.getFamilyOrFriendId()) {
					check++;
				}
			}
			if(check!=0) {
				familyFriendsDetailsService.updateDetails(familyFriendsDetails);
				return ResponseEntity.ok().body(familyFriendsDetails);
			}
			else {
				return ResponseEntity.ok().body("Entered family or Friend details are not available, cann't update those details");	
			}
		}
		else {
			return ResponseEntity.ok().body("Entered family or Friend details are not available, cann't update those details");	
		}
	}

	@DeleteMapping("/deleteDetails/{name}")
	public ResponseEntity<?> deleteDetails(@PathVariable String name){
		List<FamilyFriendsDetails> details = familyFriendsDetailsService.getFamilyFriendsDetails();
		for(FamilyFriendsDetails value : details) {
			if(value.getPersonName().equalsIgnoreCase(name)) {
				familyFriendsDetailsService.delete(value.getFamilyOrFriendId());
				return ResponseEntity.ok().body("Family or Friend details are deleted succesfully");
			}
		}
		return ResponseEntity.ok().body("Family or Friend details are not available, cann't delete those details");
	}

	@GetMapping("/getDetails/{id}")
	public ResponseEntity<?> getDetails(@PathVariable int id){
		List<FamilyFriendsDetails> details = familyFriendsDetailsService.getFamilyFriendsDetails();
		List<FamilyFriendsDetails> resultList = new ArrayList<>();
		for(FamilyFriendsDetails value : details) {
			if(value.getCustomerId()==id) {
				resultList.add(value);
			}
		}
		if(resultList.size()!=0) {
			return ResponseEntity.ok().body(resultList);
		}
		else {
			return ResponseEntity.ok().body("Family or Friend details are not available for selected customer");
		}
	}
}
