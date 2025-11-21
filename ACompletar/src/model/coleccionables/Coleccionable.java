package model.coleccionables;

import java.io.Serializable;

public abstract class Coleccionable implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String nombre;

    public Coleccionable(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

	@Override
	public String toString() {
		return "[ " + nombre + " ]";
	}   
}
