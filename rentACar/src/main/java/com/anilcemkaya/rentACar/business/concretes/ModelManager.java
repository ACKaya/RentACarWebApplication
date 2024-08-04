package com.anilcemkaya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.anilcemkaya.rentACar.business.abstracts.ModelService;
import com.anilcemkaya.rentACar.business.core.utilities.mappers.ModelMapperService;
import com.anilcemkaya.rentACar.business.requests.CreateModelRequest;
import com.anilcemkaya.rentACar.business.requests.UpdateModelRequest;
import com.anilcemkaya.rentACar.business.responses.GetAllModelResponse;
import com.anilcemkaya.rentACar.business.responses.GetByIdModelResponse;
import com.anilcemkaya.rentACar.dataAccess.abstracts.ModelRepository;
import com.anilcemkaya.rentACar.entites.concretes.Model;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	@Override
	public List<GetAllModelResponse> getAll() {
		List<Model> models=modelRepository.findAll();
		List<GetAllModelResponse> modelsResponses=models.stream().map(model-> this.modelMapperService.forResponse().map(model, GetAllModelResponse.class)).collect(Collectors.toList());
		return modelsResponses;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model=this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
	}

	@Override
	public GetByIdModelResponse getById(int id) {
		Model model=this.modelRepository.findById(id).orElseThrow();
		GetByIdModelResponse response=this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
		return response;
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model=this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);	
	}

	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);
		
	}

}
