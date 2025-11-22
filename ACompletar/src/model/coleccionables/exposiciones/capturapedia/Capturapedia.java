package model.coleccionables.exposiciones.capturapedia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import model.coleccionables.exposiciones.Exposicion;

public abstract class Capturapedia extends Exposicion implements Serializable {

    private static final long serialVersionUID = 1L;

    private final HashMap<String, Boolean> temporada;
    private ArrayList<String> horario;

    public Capturapedia(String nombre, HashMap<String, Boolean> temporada, ArrayList<String> horario) {
        super(nombre);
        this.temporada = temporada;
        this.horario = horario;
    }
    
    public HashMap<String, Boolean> getTemporada() {
        return temporada;
    }

    public ArrayList<String> getHoriario() {
        return horario;
    }

	@Override
	public String toString() {
		return super.toString() + "\n   | Temporada: " + temporada + "\n   | Horario: " + horario;
	}
}
