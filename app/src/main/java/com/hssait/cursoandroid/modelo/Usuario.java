package com.hssait.cursoandroid.modelo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by seansa on 1/10/15.
 */
@Table(name = "Usuarios")
public class Usuario extends Model {

    @Column(name = "usuario")
    public String usuario;
    @Column(name = "clave")
    public String clave;
    @Column(name = "persona")
    public Persona persona;

    public Usuario() {
    }
}
