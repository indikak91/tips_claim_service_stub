package com.tips.claim.stub.service.model.claim;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Claims {
	
	
	private String policyNo;
	private LocalDate incidentDate;
	private LocalTime incidentTime;
	
	private String policyHolderFirstName;
	private String policyHolderLastName;
	
	
	private String claimBenefitCode;
	private String benefitGroupId;
	private BigDecimal estAmount;
	private BigDecimal payoutAmount;
	private ClaimantDetail claimantDetail;
	private ClaimSupportDocument claimSupportDocument;
	
}
