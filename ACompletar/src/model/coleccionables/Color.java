package model.coleccionables;

import java.io.Serializable;

public class Color implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private boolean obtenido;
    
    public Color(String nombre) {
        this.nombre = nombre;
        this.obtenido = false;
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
}
