package com.firstproje.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.firstproje.rentACar.business.abstracts.IBrandService;
import com.firstproje.rentACar.business.requests.CreateBrandRequest;
import com.firstproje.rentACar.business.requests.UpdateBrandRequest;
import com.firstproje.rentACar.business.responses.GetAllBrandsResponse;
import com.firstproje.rentACar.business.responses.GetByIdBrandResponse;
import com.firstproje.rentACar.business.rules.BrandBusinessRules;
import com.firstproje.rentACar.core.utilities.mappers.ModelMapperService;
import com.firstproje.rentACar.dataAccess.abstracts.IBrandRepository;
import com.firstproje.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements IBrandService {
	
	private IBrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() { //burada GetAllBrandsResponse sayesinde kullanıcının hangi işlemleri görebileceğini seçtik
		
		List<Brand> brands = brandRepository.findAll();
		
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand ->this.modelMapperService.forResponse()  //6. VİDEO 1.40 da anlatıyor.
						.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		return brandsResponse;
	}



	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName()); // iş kuralı
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);//createBrandRequest in bütün alanlarını Brand clasına benzetip içindeki aynı olanları birbirine eşiliyor.
		this.brandRepository.save(brand);
		
	}



	@Override
	public GetByIdBrandResponse GetById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}



	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}



	@Override
	public void delete(int id) {
		
		this.brandRepository.deleteById(id);
		
	}	
	
}
