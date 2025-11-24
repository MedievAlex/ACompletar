package model.coleccionables;

import java.io.Serializable;
import model.TipoColor;

public class Color extends Coleccionable implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private TipoColor tipoColor;
    private boolean obtenido;
    
    public Color(String nombre, TipoColor tipoColor) {
        super(nombre);
        this.tipoColor = tipoColor;
        this.obtenido = false;
    }
    
    public TipoColor getTipoColor() {
        return tipoColor;
    }

    public boolean isObtenido() {
        return obtenido;
    }

    public void setObtenido(boolean obtenido) {
        this.obtenido = obtenido;
    }

    @Override
    public String toString() {
        return "\n   |-" + super.toString() + "\n   | Tipo Color: " + tipoColor + " | Obtenido=" + obtenido + '}';
    }
}
