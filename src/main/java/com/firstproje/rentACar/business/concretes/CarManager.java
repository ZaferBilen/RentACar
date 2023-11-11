package com.firstproje.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.firstproje.rentACar.business.abstracts.ICarService;
import com.firstproje.rentACar.business.requests.CreateCarRequest;
import com.firstproje.rentACar.business.requests.UpdateCarRequest;
import com.firstproje.rentACar.business.responses.GetAllCarsResponse;
import com.firstproje.rentACar.business.responses.GetByIdCarResponse;
import com.firstproje.rentACar.core.utilities.mappers.ModelMapperService;
import com.firstproje.rentACar.dataAccess.abstracts.ICarRepository;
import com.firstproje.rentACar.entities.concretes.Car;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements ICarService{
	
	private ModelMapperService modelMapperService;
	private ICarRepository carRepository;

	@Override
	public void delete(int id) {
		this.carRepository.deleteById(id);
		
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carRepository.save(car);
		
	}

	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = carRepository.findAll();
		
		List<GetAllCarsResponse> carsResponse = cars.stream().map(car->this.modelMapperService.forResponse()
				.map(car, GetAllCarsResponse.class)).collect(Collectors.toList());
		return carsResponse;
	}

	@Override
	public GetByIdCarResponse GetById(int id) {
		 Car car = this.carRepository.findById(id).orElseThrow();
		 
		 GetByIdCarResponse response = this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);
		 return response;
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carRepository.save(car);
		
	}

}
