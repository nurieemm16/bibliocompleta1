package com.mycompany.bibliotecanuriacompleta;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author nuria
 */
public class UsuarioLibrosPrestamoAuxiliar implements Serializable {

    private Integer id_usuario;
    private Integer id_libro;

    // Constructor por defecto
    public UsuarioLibrosPrestamoAuxiliar() {
    }

    // Constructor con parámetros
    public UsuarioLibrosPrestamoAuxiliar(Integer id_usuario, Integer id_libro) {
        this.id_usuario = id_usuario;
        this.id_libro = id_libro;
    }

    // Getters y Setters
    public Integer getId_usuario() {
        return id_usuario;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    // Sobrescribir equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioLibrosPrestamoAuxiliar that = (UsuarioLibrosPrestamoAuxiliar) o;
        return Objects.equals(id_usuario, that.id_usuario) && Objects.equals(id_libro, that.id_libro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario, id_libro);
    }
}
