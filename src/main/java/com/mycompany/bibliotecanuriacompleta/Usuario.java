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
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Integer id_usuario;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "fecha_alta")
    private Date fecha_alta;
    @Column(name = "fecha_baja")
    private Date fecha_baja;

    public Integer getId_usuario() {
        return id_usuario;
    }

    public String getNombre_usuario() {
        return nombreUsuario;
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

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombreUsuario = nombre_usuario;
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

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    Integer getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
