package com.firstproje.rentACar.business.requests;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	
	private int modelId;
	private int modelYear;
	@Size(min=6, max=11)
	private String plate;
	private double dailyPrice;
}
