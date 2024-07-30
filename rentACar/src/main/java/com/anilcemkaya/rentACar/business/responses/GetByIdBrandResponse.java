package com.anilcemkaya.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetByIdBrandResponse {
	private int id;
	private String name;

}
