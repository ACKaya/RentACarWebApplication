package com.anilcemkaya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.anilcemkaya.rentACar.business.abstracts.BrandService;
import com.anilcemkaya.rentACar.business.core.utilities.mappers.ModelMapperService;
import com.anilcemkaya.rentACar.business.requests.CreateBrandRequest;
import com.anilcemkaya.rentACar.business.requests.UpdateBrandRequest;
import com.anilcemkaya.rentACar.business.responses.GetAllBrandsResponse;
import com.anilcemkaya.rentACar.business.responses.GetByIdBrandResponse;
import com.anilcemkaya.rentACar.business.rules.BrandBusinessRules;
import com.anilcemkaya.rentACar.dataAccess.abstracts.BrandRepository;
import com.anilcemkaya.rentACar.entites.concretes.Brand;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	
	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand>brands=brandRepository.findAll();
		List<GetAllBrandsResponse>brandsResponse=brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		return brandsResponse;
	}
	@Override
	public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand=this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand=this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response=this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
				return response;
	}

	@Override
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
		Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);	
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}
}
