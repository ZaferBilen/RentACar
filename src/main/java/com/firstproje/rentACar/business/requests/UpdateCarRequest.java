package com.firstproje.rentACar.business.requests;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	
	private int modelId;
	private int modelYear;
	@Size(min=6, max=9)
	private String plate;
	private double dailyPrice;

}
