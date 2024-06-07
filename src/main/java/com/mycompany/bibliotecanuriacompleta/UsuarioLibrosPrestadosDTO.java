package com.mycompany.bibliotecanuriacompleta;
import javax.persistence.*;
import java.io.Serializable;

public class UsuarioLibrosPrestadosDTO {

    private String nombre_usuario;
    private String titulo;

    public UsuarioLibrosPrestadosDTO() {
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
