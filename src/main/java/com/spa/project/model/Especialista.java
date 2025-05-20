package com.spa.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "especialistas")
public class Especialista {

    @Id
    private String id;
    private String cc;
    private String nombre;
    private String correo;
    private int edad;
    private String contraseña;
    private List<String> horario;  // Nuevo campo: lista de horarios

    // Constructor vacío
    public Especialista() {}

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<String> getHorario() {
        return horario;
    }

    public void setHorario(List<String> horario) {
        this.horario = horario;
    }
}
