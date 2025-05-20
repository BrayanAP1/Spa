package com.spa.project.repository;

import com.spa.project.model.Cita;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CitaRepository extends MongoRepository<Cita, String> {
    List<Cita> findByClienteTelefono(String clienteTelefono);
    List<Cita> findByEspecialistaId(String especialistaId);
}
