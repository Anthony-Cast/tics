package com.example.proyecto.repository;

import com.example.proyecto.TempPres;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface tempresRepository extends MongoRepository<TempPres,String> {

}
