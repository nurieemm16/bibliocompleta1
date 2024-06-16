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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import java.util.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author nuria
 */
@Entity
@Table(name = "actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_actividad")
    private Integer id_actividad;

    @Column(name = "actividad")
    private String actividad;
    
    @Column(name = "fecha_actividad")
    private String fecha_actividad;

    public Integer getId_actividad() {
        return id_actividad;
    }

    public String getActividad() {
        return actividad;
    }

    public String getFecha_actividad() {
        return fecha_actividad;
    }

    public void setId_actividad(Integer id_actividad) {
        this.id_actividad = id_actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public void setFecha_actividad(String fecha_actividad) {
        this.fecha_actividad = fecha_actividad;
    }
    
     Integer getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
