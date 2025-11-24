package model.coleccionables.exposiciones;

import java.io.Serializable;

public class Fragmento extends Exposicion implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;

    public Fragmento(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "\n   |-" + super.toString();
    }
}
