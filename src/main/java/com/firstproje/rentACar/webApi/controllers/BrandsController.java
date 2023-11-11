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

import com.firstproje.rentACar.business.abstracts.IBrandService;
import com.firstproje.rentACar.business.requests.CreateBrandRequest;
import com.firstproje.rentACar.business.requests.UpdateBrandRequest;
import com.firstproje.rentACar.business.responses.GetAllBrandsResponse;
import com.firstproje.rentACar.business.responses.GetByIdBrandResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController  //annotation yani bilgilendirme ifadesi 
@RequestMapping("/api/brands")  //adresleme tarayıcadaki
@AllArgsConstructor
public class BrandsController {

	private IBrandService brandService;

	
	@GetMapping ()
	public List<GetAllBrandsResponse> getAll(){
		
		return brandService.getAll();
	}
	@GetMapping ("/{id}")
	public GetByIdBrandResponse getById(int id){
		
		return brandService.GetById(id);
	}
	
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid()CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	@PutMapping
	public void update(@RequestBody() @Valid() UpdateBrandRequest updateBrandRequest) {
		
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.brandService.delete(id);
	}
	
	
	
	
}



