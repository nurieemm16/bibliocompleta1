/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Autora página web: Núria Marzo Marquès

package com.mycompany.bibliotecanuriacompleta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

/**
 *
 * @author nuria
 */

//URL: http://localhost:8080/actividades
@RestController
@RequestMapping("/actividades")
public class ActividadController {
    @Autowired
    private ActividadRepository actividadRepository;

    
// GET todas las actividades
        
    @GetMapping
 public List<Actividad> getAllActividades() {
    return actividadRepository.findAll();
}


//http://localhost:8080/actividades/{id}
   
 // GET actividad por el ID
    @GetMapping("{id}")
    public ResponseEntity<Actividad> getActividadById(@PathVariable Integer id) {
        Optional<Actividad> actividad = actividadRepository.findById(id);
        if (actividad.isPresent()) {
            return ResponseEntity.ok(actividad.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @PostMapping
    public ResponseEntity<String> createActividad(@RequestBody Actividad actividad) {
        actividadRepository.save(actividad);
        return new ResponseEntity<>("Te has inscrito correctamente en nuestra actividad. ¡Gracias por confiar en nosotros!", HttpStatus.CREATED);
    }

    }

