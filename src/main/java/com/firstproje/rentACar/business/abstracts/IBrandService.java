package com.firstproje.rentACar.business.abstracts;

import java.util.List;

import com.firstproje.rentACar.business.requests.CreateBrandRequest;
import com.firstproje.rentACar.business.requests.UpdateBrandRequest;
import com.firstproje.rentACar.business.responses.GetAllBrandsResponse;
import com.firstproje.rentACar.business.responses.GetByIdBrandResponse;

public interface IBrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse GetById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
	
}
