package com.anilcemkaya.rentACar.webApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anilcemkaya.rentACar.business.abstracts.BrandService;
import com.anilcemkaya.rentACar.business.requests.CreateBrandRequest;
import com.anilcemkaya.rentACar.business.requests.UpdateBrandRequest;
import com.anilcemkaya.rentACar.business.responses.GetAllBrandsResponse;
import com.anilcemkaya.rentACar.business.responses.GetByIdBrandResponse;
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
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
	this.brandService.add(createBrandRequest);	
	}
	@GetMapping("/{id}")
	public  GetByIdBrandResponse getById(@PathVariable() int id) {
		return this.brandService.getById(id);	
	}
	@PutMapping
	public void update(@RequestBody()UpdateBrandRequest updateBrandReqeust) {
		this.brandService.update(updateBrandReqeust);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}

}
