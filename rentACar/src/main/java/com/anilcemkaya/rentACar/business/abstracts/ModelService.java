package com.anilcemkaya.rentACar.business.abstracts;

import java.util.List;

import com.anilcemkaya.rentACar.business.requests.CreateModelRequest;
import com.anilcemkaya.rentACar.business.requests.UpdateModelRequest;
import com.anilcemkaya.rentACar.business.responses.GetAllModelResponse;
import com.anilcemkaya.rentACar.business.responses.GetByIdModelResponse;

public interface ModelService {
	public List<GetAllModelResponse> getAll();
	void add(CreateModelRequest createModelRequest);
	GetByIdModelResponse getById(int id);
	void update(UpdateModelRequest updateModelRequest);
	void delete(int id);

}
