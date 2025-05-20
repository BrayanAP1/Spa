package com.spa.project.controller;

import com.spa.project.model.Especialista;
import com.spa.project.repository.EspecialistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialistas")
public class EspecialistaController {

    @Autowired
    private EspecialistaRepository repository;

    @GetMapping
    public List<Especialista> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Especialista create(@RequestBody Especialista especialista) {
        return repository.save(especialista);
    }

    @PutMapping("/{id}")
    public Especialista update(@PathVariable String id, @RequestBody Especialista especialista) {
        especialista.setId(id);
        return repository.save(especialista);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        Especialista especialista = repository.findByNombre(username);

        if (especialista != null && especialista.getContraseña().equals(password)) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}
