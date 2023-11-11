package com.firstproje.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {  // kullanıcadan data alırken girmesi gereken yerleri isteyen bölüm. 
	
	@NotNull  //name alanına veri girilmesi zorunlu anlamında.
	@NotBlank //boşluk olamaz anlamında
	@Size(min=3, max=20) //min ve maks karakter sayısı
	private String name;

}
