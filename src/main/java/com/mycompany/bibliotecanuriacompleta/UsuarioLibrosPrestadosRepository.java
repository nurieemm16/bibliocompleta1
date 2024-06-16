package com.mycompany.bibliotecanuriacompleta;
//Autora página web: Núria Marzo Marquès

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface UsuarioLibrosPrestadosRepository extends JpaRepository<UsuarioLibrosPrestados, UsuarioLibrosPrestamoAuxiliar> {

    /**
     *
     * @param nombre_usuario
     * @param titulo
     * @param fecha_prestamo
     * @param telefono
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuario_librosprestados (id_usuario, nombre_usuario, id_libro, titulo, fecha_prestamo, telefono) " +
                   "SELECT u.id_usuario, u.nombre_usuario, l.id_libro, l.titulo, :fecha_prestamo, :telefono " +
                   "FROM usuario u, libro l " +
                   "WHERE u.nombre_usuario = :nombre_usuario and u.telefono = :telefono and l.titulo = :titulo", nativeQuery = true)
    void insertUsuarioLibrosPrestados(@Param("nombre_usuario") String nombre_usuario, 
                                      @Param("titulo") String titulo,
                                      @Param("fecha_prestamo") Date fecha_prestamo,
                                      @Param("telefono") Integer telefono);

@Modifying
@Transactional
@Query(value = "UPDATE usuario_librosprestados SET fecha_devolucion = :fecha_devolucion " +
               "WHERE id_usuario = (SELECT id_usuario FROM usuario WHERE nombre_usuario = :nombre_usuario AND telefono = :telefono) " +
               "AND id_libro = (SELECT id_libro FROM libro WHERE titulo = :titulo)", nativeQuery = true)
void updateUsuarioLibrosPrestados(@Param("nombre_usuario") String nombre_usuario, 
                                  @Param("titulo") String titulo,
                                  @Param("telefono") Integer telefono,
                                  @Param("fecha_devolucion") Date fecha_devolucion);
}