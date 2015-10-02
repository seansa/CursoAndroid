package com.hssait.cursoandroid.modelo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by seansa on 2/10/15.
 */
@Table(name = "Items")
public class Item extends Model{

    @Column(name = "nombre")
    public String nombre;

    public Item() {
    }
}
