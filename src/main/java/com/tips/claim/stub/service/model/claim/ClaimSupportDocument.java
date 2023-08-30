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
public class ClaimSupportDocument {
	
	private String documentCode;
	private LocalDate fileContentBase64;
	private String fileName;

}
