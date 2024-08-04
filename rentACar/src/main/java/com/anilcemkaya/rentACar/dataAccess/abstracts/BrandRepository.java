package com.anilcemkaya.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anilcemkaya.rentACar.entites.concretes.Brand;

public  interface BrandRepository extends JpaRepository<Brand, Integer> {
	boolean existsByName(String name);
	
	

}
