package com.example.proyecto.repository;

import com.example.proyecto.model.TempPresDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempPresDao extends MongoRepository<TempPresDTO, String> {
	
	
}
