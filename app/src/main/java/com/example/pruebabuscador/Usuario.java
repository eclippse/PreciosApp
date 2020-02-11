package com.example.pruebabuscador;

public class Usuario {

    String nombre;
    String telefono;
    String email;

    public Usuario(String nom, String tel, String email){
        this.nombre = nom;
        this.telefono = tel;
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
}
