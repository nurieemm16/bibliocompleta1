package com.mycompany.bibliotecanuriacompleta;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//@author nuria

/*Entidad UsuarioLibrosPrestamo que tiene una clave primaria compuesta por id_usuario, id_libro. 
Primero, necesitas definir una clase auxiliar que represente la clave primaria compuesta (UsuarioLibrosPrestamoAuxiliar). 
Luego, se utiliza @IdClass en la entidad para indicar que esta entidad tiene una clave primaria compuesta definida por esta clase auxiliar.*/

@Entity
@Table(name = "usuario_librosprestados")
@IdClass(UsuarioLibrosPrestamoAuxiliar.class) //Indica que esta entidad tiene una clave primaria compuesta y que la clase UsuarioLibrosPrestados define esta clave
public class UsuarioLibrosPrestados implements Serializable {

    @Id //Indica que es la PK.
    private Integer id_usuario;

    private String nombre_usuario; //Aquí marcas las otras columnas que quieres en la tabla y que no son PK-FK.

    @Id //Indica que es la PK.
    private Integer id_libro;

    private String titulo; //Aquí marcas las otras columnas que quieres en la tabla y que no son PK-FK.

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
}
