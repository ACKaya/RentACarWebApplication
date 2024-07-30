package com.anilcemkaya.rentACar.webApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anilcemkaya.rentACar.business.abstracts.BrandService;
import com.anilcemkaya.rentACar.business.requests.CreateBrandRequest;
import com.anilcemkaya.rentACar.business.responses.GetAllBrandsResponse;
@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;
	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	@GetMapping("/getall")
	public List<GetAllBrandsResponse>getAll(){	
		return brandService.getAll();
	}
	@PostMapping("/add")
	@ResponseStatus()
	public void add(CreateBrandRequest createBrandRequest) {
	this.brandService.add(createBrandRequest);	
	}
	

}
