package com.firstproje.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {  // burası isteğe verilen yanıtı gösterir. Burada girdiğimiz değişkenleri kullanıcı görür.
	private int id;
	private String name;

}
