package com.firstproje.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstproje.rentACar.entities.concretes.Car;

public interface ICarRepository extends JpaRepository<Car ,Integer>{
	
}
