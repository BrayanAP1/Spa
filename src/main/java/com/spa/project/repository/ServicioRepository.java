package com.spa.project.repository;

import com.spa.project.model.Servicio;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ServicioRepository extends MongoRepository<Servicio, String> {
    List<Servicio> findByEspecialistaId(String especialistaId);
}
