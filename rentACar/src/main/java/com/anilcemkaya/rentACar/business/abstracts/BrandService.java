package com.anilcemkaya.rentACar.business.abstracts;

import java.util.List;

import com.anilcemkaya.rentACar.business.requests.CreateBrandRequest;
import com.anilcemkaya.rentACar.business.responses.GetAllBrandsResponse;
import com.anilcemkaya.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService  {
	public List <GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
	GetByIdBrandResponse getById(int id);
	

}
