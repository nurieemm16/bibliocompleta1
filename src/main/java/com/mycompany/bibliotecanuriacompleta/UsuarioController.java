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
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    
    //Obtenemos todos los usuarios
    
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    
     //Obtenemos un usuario por su ID

    @GetMapping("/{id_usuario}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id_usuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(id_usuario);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
     //Creamos un nuevo usuario

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return new ResponseEntity<>("Te has inscrito correctamente en nuestra biblioteca. ¡A disfrutar de la lectura!", HttpStatus.CREATED);
    }
    
    
   
     //Modificamos los datos de un Usuario
    
    @PutMapping("/{id_usuario}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id_usuario, @RequestBody Usuario usuarioDetails) {
        Optional<Usuario> usuario = usuarioRepository.findById(id_usuario);
        if (usuario.isPresent()) {
           Usuario usuarioToUpdate = usuario.get();
            usuarioToUpdate.setNombre_usuario(usuarioDetails.getNombre_usuario());
            usuarioToUpdate.setTelefono(usuarioDetails.getTelefono());
            usuarioToUpdate.setCorreo(usuarioDetails.getCorreo());
            usuarioToUpdate.setFecha_alta(usuarioDetails.getFecha_alta());
             usuarioToUpdate.setFecha_baja(usuarioDetails.getFecha_baja());
         return ResponseEntity.ok(usuarioRepository.save(usuarioToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Borramos un Usuario

    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id_usuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(id_usuario);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
