package com.spa.project.repository;

import com.spa.project.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByNombre(String nombre);
}
