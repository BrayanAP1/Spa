package com.spa.project.repository;

import com.spa.project.model.Especialista;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EspecialistaRepository extends MongoRepository<Especialista, String> {
    Especialista findByNombre(String nombre);
}
