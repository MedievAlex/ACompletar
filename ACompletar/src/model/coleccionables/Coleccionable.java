package model.coleccionables;

import java.io.Serializable;

public abstract class Coleccionable implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String nombre;
    private boolean obtenido;
    private boolean donado;

    public Coleccionable(String nombre) {
        this.nombre = nombre;
        this.obtenido = false;
        this.donado = false;
    }

    public String getNombre() {
        return nombre;
    }
    
     public boolean isObtenido() {
        return obtenido;
    }

    public void setObtenido(boolean obtenido) {
        this.obtenido = obtenido;
    }

    public boolean isDonado() {
        return donado;
    }

    public void setDonado(boolean donado) {
        this.donado = donado;
    }
}
