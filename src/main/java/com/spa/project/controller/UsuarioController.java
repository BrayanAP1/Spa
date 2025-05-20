package com.spa.project.controller;

import com.spa.project.model.Usuario;
import com.spa.project.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        Usuario usuario = repository.findByNombre(username);

        if (usuario != null && usuario.getContraseña().equals(password)) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
    
    @PutMapping("/{id}")
    public Usuario update(@PathVariable String id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return repository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
