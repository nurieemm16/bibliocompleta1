package com.mycompany.bibliotecanuriacompleta;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "usuario_librosprestados")
@IdClass(UsuarioLibrosPrestamoAuxiliar.class)
public class UsuarioLibrosPrestados implements Serializable {

    @Id
    private Integer id_usuario;

    private String nombre_usuario;
    
    @Id
    private Integer id_libro;

    private String titulo;

    private Date fecha_prestamo;
    private Date fecha_devolucion;
    private Integer telefono;

    // Constructor por defecto
    public UsuarioLibrosPrestados() {
    }

    // Getters y Setters
    public Integer getId_usuario() {
        return id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
}