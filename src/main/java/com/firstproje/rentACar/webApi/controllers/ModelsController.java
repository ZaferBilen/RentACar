package com.firstproje.rentACar.webApi.controllers;

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

import com.firstproje.rentACar.business.abstracts.IModelService;
import com.firstproje.rentACar.business.requests.CreateModelRequest;
import com.firstproje.rentACar.business.requests.UpdateModelRequest;
import com.firstproje.rentACar.business.responses.GetAllModelsResponse;
import com.firstproje.rentACar.business.responses.GetByIdModelResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController  
@RequestMapping("/api/models")  
@AllArgsConstructor
public class ModelsController {
	
	private IModelService modelService;
	
	@GetMapping ()
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() @Valid() UpdateModelRequest updateModelRequest) {
		
		this.modelService.update(updateModelRequest);
	}
	@GetMapping ("/{id}")
	public GetByIdModelResponse getById(int id){
		
		return modelService.GetById(id);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.modelService.delete(id);
	}
}
