package com.example.leon.appmodelogeral.entidades;

import android.graphics.drawable.Drawable;

public class Noticia {
    String manchete;
    String corpoNoticia;
    Drawable imagem;

    public Noticia(String manchete, String corpoNoticia, Drawable imagem) {
        this.manchete = manchete;
        this.corpoNoticia = corpoNoticia;
        this.imagem = imagem;
    }

    public String getManchete() {
        return manchete;
    }

    public void setManchete(String manchete) {
        this.manchete = manchete;
    }

    public String getCorpoNoticia() {
        return corpoNoticia;
    }

    public void setCorpoNoticia(String corpoNoticia) {
        this.corpoNoticia = corpoNoticia;
    }

    public Drawable getImagem() {
        return imagem;
    }

    public void setImagem(Drawable imagem) {
        this.imagem = imagem;
    }
}
