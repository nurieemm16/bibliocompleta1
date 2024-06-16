/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Autora página web: Núria Marzo Marquès
package com.mycompany.bibliotecanuriacompleta;
import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



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
    private Integer telefono_autor;
     
    @Column(name = "correo")
    private String correo_autor;
     
     @Column(name = "fecha_alta")
    private Date fecha_alta_autor;

    public Integer getId_autor() {
        return id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public Integer getTelefono_autor() {
        return telefono_autor;
    }

    public String getCorreo_autor() {
        return correo_autor;
    }

    public Date getFecha_alta_autor() {
        return fecha_alta_autor;
    }

    public void setId_autor(Integer id_autor) {
        this.id_autor = id_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public void setTelefono_autor(Integer telefono_autor) {
        this.telefono_autor = telefono_autor;
    }

    public void setCorreo_autor(String correo_autor) {
        this.correo_autor = correo_autor;
    }

    public void setFecha_alta_autor(Date fecha_alta_autor) {
        this.fecha_alta_autor = fecha_alta_autor;
    }

   

  
 }
    

