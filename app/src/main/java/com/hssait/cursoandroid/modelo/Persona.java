package com.hssait.cursoandroid.modelo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by seansa on 1/10/15.
 */
@Table(name = "Personas")
public class Persona extends Model {

    @Column(name = "nombre")
    public String nombre;
    @Column(name = "apellido")
    public String apellido;
    @Column(name = "edad")
    public int    edad;

    public Persona() {
    }
}
