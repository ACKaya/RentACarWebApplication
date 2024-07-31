package com.anilcemkaya.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateBrandRequest {
	private int id;
	private String name;
}
