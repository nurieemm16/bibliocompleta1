package com.mycompany.bibliotecanuriacompleta;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nuria
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNombreUsuario(String nombreUsuario);
   
}
