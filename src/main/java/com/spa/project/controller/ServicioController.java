package com.spa.project.controller;

import com.spa.project.model.Servicio;
import com.spa.project.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioRepository repository;

    // Obtener todos los servicios de un especialista
    @GetMapping("/especialista/{especialistaId}")
    public List<Servicio> getByEspecialista(@PathVariable String especialistaId) {
        return repository.findByEspecialistaId(especialistaId);
    }
    
    @GetMapping
    public List<Servicio> getAll() {
        return repository.findAll();
    }

    // Crear un nuevo servicio
    @PostMapping
    public Servicio create(@RequestBody Servicio servicio) {
        return repository.save(servicio);
    }

    // Editar un servicio por ID
    @PutMapping("/{id}")
    public Servicio update(@PathVariable String id, @RequestBody Servicio servicio) {
        servicio.setId(id);
        return repository.save(servicio);
    }

    // Eliminar un servicio por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
}
