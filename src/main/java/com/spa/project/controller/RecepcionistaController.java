package com.spa.project.controller;

import com.spa.project.model.Recepcionista;
import com.spa.project.repository.RecepcionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recepcionistas")
public class RecepcionistaController {

    @Autowired
    private RecepcionistaRepository repository;

    @GetMapping
    public List<Recepcionista> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Recepcionista create(@RequestBody Recepcionista recepcionista) {
        return repository.save(recepcionista);
    }

    @PutMapping("/{id}")
    public Recepcionista update(@PathVariable String id, @RequestBody Recepcionista recepcionista) {
        recepcionista.setId(id);
        return repository.save(recepcionista);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        Recepcionista recepcionista = repository.findByNombre(username);

        if (recepcionista != null && recepcionista.getContraseña().equals(password)) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}
