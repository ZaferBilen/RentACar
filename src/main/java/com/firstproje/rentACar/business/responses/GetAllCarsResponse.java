package com.firstproje.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {
	
	private int id;
	private String brandName;
	private String modelName;
	private int modelYear;
	private String plate;
	private double dailyPrice ;
	

}
