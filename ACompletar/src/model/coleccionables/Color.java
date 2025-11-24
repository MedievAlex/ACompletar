package model.coleccionables;

import java.io.Serializable;
import model.TipoColor;

public class Color extends Coleccionable implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private TipoColor tipoColor;
    
    public Color(String nombre, TipoColor tipoColor) {
        super(nombre);
        this.tipoColor = tipoColor;
    }
    
    public TipoColor getTipoColor() {
        return tipoColor;
    }

    @Override
    public String toString() {
        return "\n   |-" + super.toString() + "\n   | Tipo Color: " + tipoColor;
    }
}
