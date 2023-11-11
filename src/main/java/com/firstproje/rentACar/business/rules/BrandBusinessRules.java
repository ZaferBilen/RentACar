package com.firstproje.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.firstproje.rentACar.core.utilities.exceptions.BusinessException;
import com.firstproje.rentACar.dataAccess.abstracts.IBrandRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	
	private IBrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name already exists");
		}
	}
	
	

}
