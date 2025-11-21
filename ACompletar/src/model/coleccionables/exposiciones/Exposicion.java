package model.coleccionables.exposiciones;

import java.io.Serializable;

import model.coleccionables.Coleccionable;

public class Exposicion extends Coleccionable implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean donado;

    public Exposicion(String nombre) {
        super(nombre);
        this.donado = false;
    }

    public boolean isDonado() {
        return donado;
    }

    public void setDonado(boolean donado) {
        this.donado = donado;
    }

    @Override
	public String toString() {
		return super.toString() + " | Donado: " + donado;
	}
}
