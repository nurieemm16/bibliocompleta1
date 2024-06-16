package com.mycompany.bibliotecanuriacompleta;

//Autora página web: Núria Marzo Marquès

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Date;

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

    
    //Obtener todos los libros que han sido prestados
    
    @GetMapping
    public List<UsuarioLibrosPrestados> getAllUsuariosLibrosPrestados() {
        return usuarioLibrosPrestadosRepository.findAll();
    }
    
    
    // Obtener un préstamo por ID http://localhost:8080/usuarios/prestamos/{id_usuario}/{id_libro}
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
 public ResponseEntity<String> insertUsuarioLibrosPrestados(@RequestBody UsuarioLibrosPrestadosDTO usuarioLibrosPrestadosDTO) {
        Usuario usuario = usuarioRepository.findByNombreUsuarioAndTelefono(usuarioLibrosPrestadosDTO.getNombre_usuario(), usuarioLibrosPrestadosDTO.getTelefono());
        Libro libro = libroRepository.findByTitulo(usuarioLibrosPrestadosDTO.getTitulo());

        if (usuario != null && libro != null && libro.getDisponibilidad()) {
            UsuarioLibrosPrestados usuarioLibrosPrestados = new UsuarioLibrosPrestados();
            usuarioLibrosPrestados.setId_usuario(usuario.getId_usuario());
            usuarioLibrosPrestados.setNombre_usuario(usuario.getNombre_usuario());
            usuarioLibrosPrestados.setId_libro(libro.getId_libro());
            usuarioLibrosPrestados.setTitulo(libro.getTitulo());
            usuarioLibrosPrestados.setFecha_prestamo(usuarioLibrosPrestadosDTO.getFecha_prestamo());
            usuarioLibrosPrestados.setTelefono(usuarioLibrosPrestadosDTO.getTelefono());

            usuarioLibrosPrestadosRepository.save(usuarioLibrosPrestados);

           // Actualizar la disponibilidad del libro
            libro.setDisponibilidad(false);
            libroRepository.save(libro);

            return ResponseEntity.ok("Has cogido prestado el libro correctamente. ¡Que disfrutes de la lectura!");
        } else {
            return ResponseEntity.status(404).body("¡Ups! Parece que algún dato que has introducido no es correcto. Te rogamos que introduzcas tus datos de nuevo. También asegúrate de que el libro que quieras coger prestado esté disponible, vas a poder ver su disponibilidad en el catálogo de libros.");
        }
    }
 
 /* actualizar un préstamo http://localhost:8080/usuarios/prestamos/{id_usuario}/{id_libro}
    @PutMapping("/{id_usuario}/{id_libro}")
     public ResponseEntity<UsuarioLibrosPrestados> updateUsuarioLibrosPrestados(@PathVariable int id_usuario, @PathVariable int id_libro, @RequestBody UsuarioLibrosPrestadosDTO usuarioLibrosPrestadosDTO) {
        UsuarioLibrosPrestamoAuxiliar key = new UsuarioLibrosPrestamoAuxiliar(id_usuario, id_libro);
        Optional<UsuarioLibrosPrestados> existingRecord = usuarioLibrosPrestadosRepository.findById(key);

        if (existingRecord.isPresent()) {
            UsuarioLibrosPrestados record = existingRecord.get();
            record.setFecha_devolucion(usuarioLibrosPrestadosDTO.getFecha_devolucion());
            usuarioLibrosPrestadosRepository.save(record);
            return ResponseEntity.ok(record);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

  //Eliminar un préstamo:http://localhost:8080/usuarios/prestamos/devolver

 @PutMapping("/devolver")
public ResponseEntity<String> updateUsuarioLibrosPrestados(@RequestBody UsuarioLibrosPrestadosDTO usuarioLibrosPrestadosDTO) {
    Usuario usuario = usuarioRepository.findByNombreUsuarioAndTelefono(usuarioLibrosPrestadosDTO.getNombre_usuario(), usuarioLibrosPrestadosDTO.getTelefono());
    Libro libro = libroRepository.findByTitulo(usuarioLibrosPrestadosDTO.getTitulo());

    if (usuario != null && libro != null) {
        try {
            usuarioLibrosPrestadosRepository.updateUsuarioLibrosPrestados(
                    usuarioLibrosPrestadosDTO.getNombre_usuario(),
                    usuarioLibrosPrestadosDTO.getTitulo(),
                    usuarioLibrosPrestadosDTO.getTelefono(),
                    usuarioLibrosPrestadosDTO.getFecha_devolucion()
            );

            // Actualizar la disponibilidad del libro
            libro.setDisponibilidad(true);
            libroRepository.save(libro);

            return ResponseEntity.ok("Has devuelto el libro correctamente. ¡Esperamos que hayas disfrutado de la lectura!");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Parece que no has realizado el préstamo de este libro. Inténtalo de nuevo.");
        }
    } else {
        return ResponseEntity.status(404).body("Tu nombre de usuario, el título del libro o tu teléfono no son correctos. Te rogamos que introduzcas los datos de nuevo.");
    }
}
}