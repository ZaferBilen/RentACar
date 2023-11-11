package com.firstproje.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstproje.rentACar.entities.concretes.Brand;


public interface IBrandRepository extends JpaRepository<Brand,Integer>{
	boolean existsByName(String name);
	

}
