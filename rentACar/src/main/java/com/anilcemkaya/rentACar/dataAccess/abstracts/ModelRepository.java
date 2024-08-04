package com.anilcemkaya.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anilcemkaya.rentACar.entites.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
	
}
