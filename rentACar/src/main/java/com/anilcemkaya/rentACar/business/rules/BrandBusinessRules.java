package com.anilcemkaya.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.anilcemkaya.rentACar.business.core.utilities.exceptions.BusinessException;
import com.anilcemkaya.rentACar.dataAccess.abstracts.BrandRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name has already exists");
		}
	}

}
