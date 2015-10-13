package com.hssait.cursoandroid.modelo;

/**
 * Created by seansa on 12/10/15.
 */
public class Noticia {

    public String titulo;
    public String imgUrl;
    public String urlNoticia;

    public Noticia() {
    }

    public Noticia(String imgUrl, String titulo, String urlNoticia) {
        this.imgUrl = imgUrl;
        this.titulo = titulo;
        this.urlNoticia = urlNoticia;
    }

}
