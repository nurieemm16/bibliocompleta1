/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Autora página web: Núria Marzo Marquès
package com.mycompany.bibliotecanuriacompleta;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nuria
 */
@Entity
@Table(name = "libro")
public class Libro {
    
      @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_libro")
    private Integer id_libro;

    @Column(name = "titulo")
    private String titulo;
    
     @Column(name = "autor")
    private String autor;
     
     @Column(name = "fecha_publicacion")
    private Date fecha_publicacion;
     
     @Column(name = "disponibilidad")
    private Boolean disponibilidad;
     
      @Column(name = "genero")
    private String genero;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    Integer getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

    
    
}
