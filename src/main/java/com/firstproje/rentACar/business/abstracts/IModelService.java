package com.firstproje.rentACar.business.abstracts;

import java.util.List;

import com.firstproje.rentACar.business.requests.CreateModelRequest;
import com.firstproje.rentACar.business.requests.UpdateModelRequest;
import com.firstproje.rentACar.business.responses.GetAllModelsResponse;
import com.firstproje.rentACar.business.responses.GetByIdModelResponse;

public interface IModelService {
	List<GetAllModelsResponse> getAll();
	GetByIdModelResponse GetById(int id);
	void add(CreateModelRequest createModelRequest);
	void update(UpdateModelRequest updateModelRequest);
	void delete(int id);
}
