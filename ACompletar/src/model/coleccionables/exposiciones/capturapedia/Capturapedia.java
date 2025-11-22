package model.coleccionables.exposiciones.capturapedia;

import java.io.Serializable;
import java.util.HashMap;

import model.coleccionables.exposiciones.Exposicion;

public abstract class Capturapedia extends Exposicion implements Serializable {

    private static final long serialVersionUID = 1L;

    private final HashMap<String, Boolean> temporada;
    private final String horiario;

    public Capturapedia(String nombre, HashMap<String, Boolean> temporada, String horario) {
        super(nombre);
        this.temporada = temporada;
        this.horiario = horario;
    }
    
    public HashMap<String, Boolean> getTemporada() {
        return temporada;
    }

    public String getHoriario() {
        return horiario;
    }

	@Override
	public String toString() {
		return super.toString() + "\n   | Temporada: " + temporada + "\n   | Horiario: " + horiario;
	}
}
