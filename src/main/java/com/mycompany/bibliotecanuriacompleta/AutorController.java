/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecanuriacompleta;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

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
    // GET all authors
    @GetMapping
 public List<Autor> getAllAutores() {
    return autorRepository.findAll();
}
//http://localhost:8080/autores/{id}
    // GET author by ID
    @GetMapping("{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Integer id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()) {
            return ResponseEntity.ok(autor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    //http://localhost:8080/autores
    // POST create a new author
    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    
    //http://localhost:8080/autores/{id}
    // PUT update an author
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
    
}