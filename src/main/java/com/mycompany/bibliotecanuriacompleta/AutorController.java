/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecanuriacompleta;
//Autora página web: Núria Marzo Marquès

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

/**
 *
 * @author nuria
 */
@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;
//URL: http://localhost:8080/autores
    
// GET todos los autores
        
    @GetMapping
 public List<Autor> getAllAutores() {
    return autorRepository.findAll();
}
//http://localhost:8080/autores/{id}
   


 // GET autor por el ID
    @GetMapping("{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Integer id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()) {
            return ResponseEntity.ok(autor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @PostMapping
    public ResponseEntity<String> createAutor(@RequestBody Autor autor) {
        autorRepository.save(autor);
        return new ResponseEntity<>("Te has inscrito correctamente como autor/a en nuestra biblioteca. ¡Gracias por publicar tus obras en Códex-Arús!", HttpStatus.CREATED);
    }

  /*
    
    //http://localhost:8080/autores/{id}
    //Cambia datos autor
    @PutMapping("{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Integer id, @RequestBody Autor autorDetails) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()) {
            Autor autorToUpdate = autor.get();
            autorToUpdate.setNombre_autor(autorDetails.getNombre_autor());
            autorToUpdate.setTelefono(autorDetails.getTelefono());
            autorToUpdate.setCorreo(autorDetails.getCorreo());
            autorToUpdate.setFecha_alta(autorDetails.getFecha_alta());
         return ResponseEntity.ok(autorRepository.save(autorToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Borra autor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Integer id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()) {
            autorRepository.delete(autor.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    */
} 