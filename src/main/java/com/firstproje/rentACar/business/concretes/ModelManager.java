package com.firstproje.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.firstproje.rentACar.business.abstracts.IModelService;
import com.firstproje.rentACar.business.requests.CreateModelRequest;
import com.firstproje.rentACar.business.requests.UpdateModelRequest;
import com.firstproje.rentACar.business.responses.GetAllModelsResponse;
import com.firstproje.rentACar.business.responses.GetByIdModelResponse;
import com.firstproje.rentACar.core.utilities.mappers.ModelMapperService;
import com.firstproje.rentACar.dataAccess.abstracts.ModelRepository;
import com.firstproje.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService{

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model ->this.modelMapperService.forResponse()  //6. VİDEO 1.40 da anlatıyor.
						.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

	@Override
	public GetByIdModelResponse GetById(int id) {
		Model model = this.modelRepository.findById(id).orElseThrow();
		
		GetByIdModelResponse response = this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
		return response;
	}

	@Override
	public void delete(int id) {

		this.modelRepository.deleteById(id);
		
	}

}
