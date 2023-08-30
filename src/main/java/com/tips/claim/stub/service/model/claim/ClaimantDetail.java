package com.tips.claim.stub.service.model.claim;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClaimantDetail {
	
	private String insurerPersonId;
	private String firstName;
	private String lastName;
	private int identityType;
	
	private String idNo;
	private String email;
	private String contactNumber;	
	private int relationship;
	private LocalDate dob;
	private String paymentMethod;	
	
	private String bankAccountNumber;		
	private String address;		
	

}
