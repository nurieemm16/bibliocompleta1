package com.mycompany.bibliotecanuriacompleta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador para gestionar los préstamos de libros a los usuarios.
 */
@RestController
@RequestMapping("/usuarios/prestamos")
public class UsuarioLibrosPrestadosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UsuarioLibrosPrestadosRepository usuarioLibrosPrestadosRepository;

    @GetMapping
    public List<UsuarioLibrosPrestados> getAllUsuarios() {
        return usuarioLibrosPrestadosRepository.findAll();
    }
    // obtener un préstamo por ID http://localhost:8080/usuarios/prestamos/{id_usuario}/{id_libro}
      @GetMapping("/{id_usuario}/{id_libro}")
    public ResponseEntity<UsuarioLibrosPrestados> getUsuarioLibrosPrestadosById(@PathVariable int id_usuario, @PathVariable int id_libro) {
        UsuarioLibrosPrestamoAuxiliar key = new UsuarioLibrosPrestamoAuxiliar(id_usuario, id_libro);
        Optional<UsuarioLibrosPrestados> record = usuarioLibrosPrestadosRepository.findById(key);

        if (record.isPresent()) {
            return ResponseEntity.ok(record.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 //PRESTAR UN LIBRO:http://localhost:8080/usuarios/prestamos
    @PostMapping
    public void insertUsuarioLibrosPrestados(@RequestBody UsuarioLibrosPrestadosDTO usuarioLibrosPrestadosDTO) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(usuarioLibrosPrestadosDTO.getNombre_usuario());
        Libro libro = libroRepository.findByTitulo(usuarioLibrosPrestadosDTO.getTitulo());

        if (usuario != null && libro != null) {
            usuarioLibrosPrestadosRepository.insertUsuarioLibrosPrestados(usuario.getNombre_usuario(), libro.getTitulo());
        } else {
            throw new RuntimeException("Usuario o libro no encontrado");
        }
    }
// actualizar un préstamo http://localhost:8080/usuarios/prestamos/{id_usuario}/{id_libro}
    @PutMapping("/{id_usuario}/{id_libro}")
    public ResponseEntity<UsuarioLibrosPrestados> updateUsuarioLibrosPrestados(@PathVariable int id_usuario, @PathVariable int id_libro, @RequestBody UsuarioLibrosPrestadosDTO usuarioLibrosPrestadosDTO) {
        UsuarioLibrosPrestamoAuxiliar key = new UsuarioLibrosPrestamoAuxiliar(id_usuario, id_libro);
        Optional<UsuarioLibrosPrestados> existingRecord = usuarioLibrosPrestadosRepository.findById(key);

        if (existingRecord.isPresent()) {
            UsuarioLibrosPrestados record = existingRecord.get();
            record.setNombre_usuario(usuarioLibrosPrestadosDTO.getNombre_usuario());
            record.setTitulo(usuarioLibrosPrestadosDTO.getTitulo());
            usuarioLibrosPrestadosRepository.save(record);
            return ResponseEntity.ok(record);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  //eliminar un préstamo:http://localhost:8080/usuarios/prestamos/{id_usuario}/{id_libro}

    @DeleteMapping("/{id_usuario}/{id_libro}")
    public ResponseEntity<Void> deleteUsuarioLibrosPrestados(@PathVariable int id_usuario, @PathVariable int id_libro) {
        UsuarioLibrosPrestamoAuxiliar key = new UsuarioLibrosPrestamoAuxiliar(id_usuario, id_libro);
        Optional<UsuarioLibrosPrestados> existingRecord = usuarioLibrosPrestadosRepository.findById(key);

        if (existingRecord.isPresent()) {
            usuarioLibrosPrestadosRepository.delete(existingRecord.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
