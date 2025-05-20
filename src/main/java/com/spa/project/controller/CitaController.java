package com.spa.project.controller;

import com.spa.project.model.Cita;
import com.spa.project.model.Servicio;
import com.spa.project.model.Especialista;
import com.spa.project.repository.CitaRepository;
import com.spa.project.repository.ServicioRepository;
import com.spa.project.repository.EspecialistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaRepository repository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private EspecialistaRepository especialistaRepository;

    // Agendar una nueva cita
    @PostMapping
    public Cita agendar(@RequestBody Cita cita) {
        return repository.save(cita);
    }

    // Obtener todas las citas con info de servicio y especialista
 // Obtener todas las citas con info de servicio y especialista
    @GetMapping
    public List<Map<String, Object>> obtenerTodas() {
        List<Cita> citas = repository.findAll();
        List<Map<String, Object>> resultado = new ArrayList<>();

        for (Cita cita : citas) {
            Map<String, Object> datos = new HashMap<>();
            datos.put("fecha", cita.getFecha());
            datos.put("hora", cita.getHora());
            datos.put("clienteNombre", cita.getClienteNombre());
            datos.put("clienteTelefono", cita.getClienteTelefono());

            Servicio servicio = servicioRepository.findById(cita.getServicioId()).orElse(null);
            datos.put("servicioId", cita.getServicioId());
            datos.put("servicioNombre", servicio != null ? servicio.getNombre() : "No encontrado");

            Especialista especialista = especialistaRepository.findById(cita.getEspecialistaId()).orElse(null);
            datos.put("especialistaId", cita.getEspecialistaId());
            datos.put("especialistaNombre", especialista != null ? especialista.getNombre() : "No encontrado");

            resultado.add(datos);
        }

        return resultado;
    }


    // Ver citas por número de teléfono (cliente)
    @GetMapping("/cliente/{telefono}")
    public List<Cita> getByCliente(@PathVariable String telefono) {
        return repository.findByClienteTelefono(telefono);
    }

    // Ver citas por especialista
    @GetMapping("/especialista/{especialistaId}")
    public List<Cita> getByEspecialista(@PathVariable String especialistaId) {
        return repository.findByEspecialistaId(especialistaId);
    }

    // Eliminar una cita
    @DeleteMapping("/{id}")
    public void cancelar(@PathVariable String id) {
        repository.deleteById(id);
    }
}
