package com.spa.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citas")
public class Cita {

    @Id
    private String id;
    private String clienteNombre;
    private String clienteTelefono;
    private String servicioId;
    private String especialistaId;
    private String fecha; // Formato sugerido: "2025-05-20"
    private String hora;  // Ejemplo: "10:30 AM"

    // Getters y Setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }

    public String getClienteTelefono() { return clienteTelefono; }
    public void setClienteTelefono(String clienteTelefono) { this.clienteTelefono = clienteTelefono; }

    public String getServicioId() { return servicioId; }
    public void setServicioId(String servicioId) { this.servicioId = servicioId; }

    public String getEspecialistaId() { return especialistaId; }
    public void setEspecialistaId(String especialistaId) { this.especialistaId = especialistaId; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
}
