/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecanuriacompleta;
import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "autor")
public class Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_autor")
    private Integer id_autor;

    @Column(name = "nombre_autor")
    private String nombre_autor;
    
     @Column(name = "telefono")
    private Integer telefono;
     
     @Column(name = "correo")
    private String correo;
     
     @Column(name = "fecha_alta")
    private Date fecha_alta;

    public Integer getId_autor() {
        return id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setId_autor(Integer id_autor) {
        this.id_autor = id_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

  

  
 }
    

