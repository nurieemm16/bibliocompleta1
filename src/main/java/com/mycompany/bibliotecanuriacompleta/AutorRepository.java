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
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nuria
 */
public interface AutorRepository extends JpaRepository<Autor, Integer> {

    // Aquí se pueden añadir métodos personalizados, si fuera necesario
}
