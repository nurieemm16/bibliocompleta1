package com.mycompany.bibliotecanuriacompleta;

//Autora página web: Núria Marzo Marquès

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//Representa la tabla usuario_librosprestados en la base de datos y define la estructura de los datos almacenados.


@Entity
@Table(name = "usuario_librosprestados")
@IdClass(UsuarioLibrosPrestamoAuxiliar.class) // Esta clase utiliza @IdClass(UsuarioLibrosPrestamoAuxiliar.class) para definir una clave compuesta. Es decir, la combinación de id_usuario e id_libro forman la clave primaria.
public class UsuarioLibrosPrestados implements Serializable { // para permitir que sus instancias puedan ser convertidas a un flujo de bytes, lo cual es útil para la persistencia y la transmisión a través de la red.

    @Id
    private Integer id_usuario; //Marcamos cómo clave primaria

    private String nombre_usuario;
    
    @Id
    private Integer id_libro; //Marcamos cómo clave primaria

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