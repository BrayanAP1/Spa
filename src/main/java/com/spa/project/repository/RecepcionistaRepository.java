package com.spa.project.repository;

import com.spa.project.model.Recepcionista;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecepcionistaRepository extends MongoRepository<Recepcionista, String> {
    Recepcionista findByNombre(String nombre);
}
