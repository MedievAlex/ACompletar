package model.coleccionables;

import java.io.Serializable;

public abstract class Coleccionable implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String nombre;
    private boolean obtenido;

    public Coleccionable(String nombre) {
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

	@Override
	public String toString() {
		return "[ " + nombre + " ]\n   | Obtenido: " + obtenido;
	} 
	
	public String nameToString() {
		return "[ " + nombre + " ]";
	} 
}
