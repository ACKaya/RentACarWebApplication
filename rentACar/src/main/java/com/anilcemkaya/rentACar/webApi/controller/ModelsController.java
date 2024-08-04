package com.anilcemkaya.rentACar.webApi.controller;

import java.util.List;

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

import com.anilcemkaya.rentACar.business.abstracts.ModelService;
import com.anilcemkaya.rentACar.business.requests.CreateModelRequest;
import com.anilcemkaya.rentACar.business.requests.UpdateModelRequest;
import com.anilcemkaya.rentACar.business.responses.GetAllModelResponse;
import com.anilcemkaya.rentACar.business.responses.GetByIdModelResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {
	private ModelService modelService;
	
	@GetMapping("/getall")
	public List<GetAllModelResponse> getAll(){
		return this.modelService.getAll();
	} 
	@GetMapping("/{id}")
	public GetByIdModelResponse getById(@PathVariable int id) {
		return this.modelService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid()CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}
	@PutMapping
	public void update(@RequestBody() UpdateModelRequest updateModelRequest) {
		this.modelService.update(updateModelRequest);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.modelService.delete(id);
	}
	

}
