package com.anilcemkaya.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllModelResponse {
	private int id;
	private String name;
	private String brandName;

}
