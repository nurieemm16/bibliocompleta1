/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Autora página web: Núria Marzo Marquès
package com.mycompany.bibliotecanuriacompleta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nuria
 */


import java.util.List;
import java.util.Optional;

// Marca la clase como un controlador REST, lo que significa que manejará las solicitudes HTTP
@RestController
// Define la ruta base para las solicitudes HTTP manejadas por este controlador
@RequestMapping("/libros")
public class LibroController {

    // Inyecta una instancia de LibroRepository, que proporciona métodos para interactuar con la base de datos
    @Autowired
    private LibroRepository libroRepository;

  
    /* 
    Para obtener todos los libros
    GET http://localhost:8080/libros
    */
    @GetMapping
    public List<Libro> getAllLibros() {
        // Llama al método findAll() del repositorio para obtener todos los libros
        return libroRepository.findAll();
    }
    
    
     // Maneja las solicitudes GET a /libros/{id} para obtener un libro específico por su ID
    /* 
    
    GET http://localhost:8080/libros/1
    */
    @GetMapping("{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Integer id) {
        // Busca un libro por su ID
        Optional<Libro> result=libroRepository.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    // Añade libro

    @PostMapping
    public ResponseEntity<String> createLibro(@RequestBody Libro libro) {
        libroRepository.save(libro);
        return new ResponseEntity<>("Libro publicado correctamente. ¡Muchas gracias por dar a conocer tu obra en nuestra biblioteca!", HttpStatus.CREATED);
    }
    
    
    // Cambia la disponibilidad del libro
    /* 
    Ruta:
    PUT http://localhost:8080/libros/updateDispo/1
    */
  @PutMapping("updateDispo/{id}")
public ResponseEntity<Libro> updateDispoLibro(@PathVariable Integer id) {
    // Busca un libro por su ID
    Optional<Libro> result = libroRepository.findById(id);
    if (result.isPresent()) {
        Libro libroToUpdate = result.get();
        Boolean disponibilidad = libroToUpdate.getDisponibilidad(); // Coge valor actual
        // Invertir la disponibilidad
        libroToUpdate.setDisponibilidad(!disponibilidad);
        libroRepository.save(libroToUpdate); // guarda el objeto actualizado en la base de datos
        return ResponseEntity.ok(libroToUpdate);
    } else {
        return ResponseEntity.notFound().build();
    }
}


    // http://localhost:8080/libros/1
    /* Cambia las características del libro {
    "titulo": "Nuevo Titulo",
    "autor": "Nuevo Autor"
    }     */

      @PutMapping("{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable int id, @RequestBody Libro libroDetails) {
        Optional<Libro> result = libroRepository.findById(id);
        if (result.isPresent()) {
            Libro libroToUpdate = result.get();
            libroToUpdate.setTitulo(libroDetails.getTitulo());
            libroToUpdate.setAutor(libroDetails.getAutor());
            libroToUpdate.setFecha_publicacion(libroDetails.getFecha_publicacion());
            libroToUpdate.setDisponibilidad(libroDetails.getDisponibilidad());
            libroToUpdate.setGenero(libroDetails.getGenero());
            
            return ResponseEntity.ok(libroRepository.save(libroToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    

   // Borra Libros
    
     @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable int id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

