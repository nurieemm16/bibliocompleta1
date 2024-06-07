package com.mycompany.bibliotecanuriacompleta;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nuria
 */
@Repository
public interface UsuarioLibrosPrestadosRepository extends JpaRepository<UsuarioLibrosPrestados, UsuarioLibrosPrestamoAuxiliar> {
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuario_librosprestados (id_usuario, nombre_usuario, id_libro, titulo) " +
                   "SELECT u.id_usuario, u.nombre_usuario, l.id_libro, l.titulo " +
                   "FROM usuario u, libro l " +
                   "WHERE u.nombre_usuario = :nombre_usuario and l.titulo = :titulo", nativeQuery = true)
    void insertUsuarioLibrosPrestados(@Param("nombre_usuario") String nombre_usuario, @Param("titulo") String titulo);
}
