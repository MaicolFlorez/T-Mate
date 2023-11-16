package com.mflorezddelgado.t_mate;

public class Evento {
    public String asunto;
    public String descripcion;

    public Evento(String asunto, String descripcion) {
        this.asunto = asunto;
        this.descripcion = descripcion;
    }

    public Evento() {
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
