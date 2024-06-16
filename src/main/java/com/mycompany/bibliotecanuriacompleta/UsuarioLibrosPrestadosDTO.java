package com.mycompany.bibliotecanuriacompleta;
//Autora página web: Núria Marzo Marquès
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//Esta es una clase DTO (Data Transfer Object) que se utiliza para transferir datos entre diferentes capas de la aplicación, como entre la capa de presentación y la capa de negocio.  Utilizado para transportar datos entre diferentes partes de la aplicación sin involucrarse directamente con la persistencia.

public class UsuarioLibrosPrestadosDTO {
    private int id_usuario;
    private String nombre_usuario;
    private int id_libro;
    private String titulo;
    private Integer telefono;
    private Date fecha_prestamo;
    private Date fecha_devolucion;

    public UsuarioLibrosPrestadosDTO() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public int getId_libro() {
        return id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    
    
}