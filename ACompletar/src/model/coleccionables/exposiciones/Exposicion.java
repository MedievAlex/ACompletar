package model.coleccionables.exposiciones;

import java.io.Serializable;

import model.coleccionables.Coleccionable;

public class Exposicion extends Coleccionable implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean obtenido;
    private boolean donado;

    public Exposicion(String nombre) {
        super(nombre);
        this.obtenido = false;
        this.donado = false;
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
		return super.toString() + "\n   | Obtenido: " + obtenido + " | Donado: " + donado;
	}
}
