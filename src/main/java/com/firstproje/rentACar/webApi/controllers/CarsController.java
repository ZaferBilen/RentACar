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

import com.firstproje.rentACar.business.abstracts.ICarService;
import com.firstproje.rentACar.business.requests.CreateCarRequest;
import com.firstproje.rentACar.business.requests.UpdateCarRequest;
import com.firstproje.rentACar.business.responses.GetAllCarsResponse;
import com.firstproje.rentACar.business.responses.GetByIdCarResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController  //annotation yani bilgilendirme ifadesi 
@RequestMapping("/api/cars")  //adresleme tarayıcadaki
@AllArgsConstructor
public class CarsController {
	
	private ICarService carService;

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.carService.delete(id);
	}
	
	@GetMapping ()
	public List<GetAllCarsResponse> getAll(){
		return carService.getAll();
	}
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateCarRequest createCarRequest) {
		this.carService.add(createCarRequest);
	}
	
	@GetMapping ("/{id}")
	public GetByIdCarResponse getById(int id){
		
		return carService.GetById(id);
	}
	@PutMapping
	public void update(@RequestBody() @Valid() UpdateCarRequest updateCarRequest) {
		this.carService.update(updateCarRequest);
	}
	
	
}
