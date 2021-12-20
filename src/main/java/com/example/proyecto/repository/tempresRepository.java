package com.example.proyecto.repository;

import com.example.proyecto.TempPres;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface tempresRepository extends MongoRepository<TempPres, Integer> {

}
