package com.firstproje.rentACar.business.abstracts;

import java.util.List;

import com.firstproje.rentACar.business.requests.CreateCarRequest;
import com.firstproje.rentACar.business.requests.UpdateCarRequest;
import com.firstproje.rentACar.business.responses.GetAllCarsResponse;
import com.firstproje.rentACar.business.responses.GetByIdCarResponse;

public interface ICarService  {
	List<GetAllCarsResponse> getAll();
	GetByIdCarResponse GetById(int id);
	void add(CreateCarRequest createModelRequest);
	void delete(int id);
	void update(UpdateCarRequest updateCarRequest);

}
