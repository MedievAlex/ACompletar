package model.coleccionables;

import java.io.Serializable;

public class Fragmento implements Serializable { 

	private static final long serialVersionUID = 1L;
	        
    private String nombre;
    private boolean obtenido;
    private boolean donado;

    public Fragmento(String nombre) {
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

	@Override
	public String toString() {
		return "\n   |-[ " + nombre + " ]\n   | Obtenido: " + obtenido + " | Donado: " + donado;
	}
}
