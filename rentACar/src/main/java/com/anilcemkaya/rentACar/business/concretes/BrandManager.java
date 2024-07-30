package com.anilcemkaya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anilcemkaya.rentACar.business.abstracts.BrandService;
import com.anilcemkaya.rentACar.business.core.utilities.mappers.ModelMapperService;
import com.anilcemkaya.rentACar.business.requests.CreateBrandRequest;
import com.anilcemkaya.rentACar.business.responses.GetAllBrandsResponse;
import com.anilcemkaya.rentACar.business.responses.GetByIdBrandResponse;
import com.anilcemkaya.rentACar.dataAccess.abstracts.BrandRepository;
import com.anilcemkaya.rentACar.entites.concretes.Brand;
@Service
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand>brands=brandRepository.findAll();
		List<GetAllBrandsResponse>brandsResponse=brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		return brandsResponse;
	}
	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		Brand brand=this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
