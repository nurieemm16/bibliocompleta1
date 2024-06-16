/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

//Autora página web: Núria Marzo Marquès
package com.mycompany.bibliotecanuriacompleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.*;
import java.util.*;

/**
 *
 * @author nuria
 */



public interface LibroRepository extends JpaRepository<Libro, Integer> {
    
    
  /* Aquí añadimos nuevos métodos y peticiones asociadas que no existen en JPA*/
    
  

    public Libro findByTitulo(String titulo);
    
    
}