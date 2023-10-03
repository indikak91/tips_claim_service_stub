package com.tips.claim.stub.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tips.claim.stub.service.model.claim.ClaimantDetail;
import com.tips.claim.stub.service.model.claim.Claims;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/v2/claims")
@Tag(name = "Claims Service Endpoints", description = "The list of endpoints defines in the Claims Service Controller") 
public class ClaimServiceController {

	@GetMapping(path = "/status")
	public String getStatus() {
		return "success";
	}

	@PostMapping(path = "/")
	public String createClaim(@RequestBody Claims claimRequest) {
		return "success";
	}	
	
	
	@Operation(summary = "Get a claim by its id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the Claim", 
	    content = { @Content(mediaType = "application/json",
	      schema = @Schema(implementation = Claims.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid claim id supplied", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Claim not found", 
	    content = @Content) })	
	@GetMapping(path = "/{id}")
	public Claims  getById(@Parameter(description = "id of the claim to be searched") @PathVariable long id) {
		//return repository.findById(id).orElseThrow(() -> new BookNotFoundException());
		System.out.println("test message...");
		return new Claims(). builder()
				.policyNo("LK456-9089")
				.incidentDate(LocalDate.now())
				.incidentTime(LocalTime.now())
				
				.policyHolderFirstName("Indika")
				.policyHolderLastName("Kularatne")
				
				.claimBenefitCode("CLA_9089")
				.benefitGroupId("9089")
				.estAmount(BigDecimal.valueOf(9000.00))
				.payoutAmount(BigDecimal.valueOf(8400.00))
				.claimantDetail(new ClaimantDetail("234", "David", "Martin", 2, "89909009L", "myemail@yahoo.com", "65890989234", 0, LocalDate.now().minusYears(45), getStatus(), "87623-29872-97242", "Colombo"))
				.build();		
	}
	

	

}
