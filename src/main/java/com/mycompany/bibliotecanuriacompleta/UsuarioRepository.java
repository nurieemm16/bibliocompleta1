package com.mycompany.bibliotecanuriacompleta;
//Autora página web: Núria Marzo Marquès

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nuria
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNombreUsuario(String nombreUsuario);
    Usuario findByNombreUsuarioAndTelefono(String nombreUsuario, Integer telefono); //esto servirá para el método de comprobar que el teléfono corresponde con su Usuario
   
}
