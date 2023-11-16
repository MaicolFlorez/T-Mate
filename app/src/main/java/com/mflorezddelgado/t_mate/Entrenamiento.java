package com.mflorezddelgado.t_mate;

public class Entrenamiento {

    public String titulo;
    public String descripcion;
    public String caracteristicas;

    public Entrenamiento(String titulo, String descripcion, String caracteristicas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
    }

    public Entrenamiento() {
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
