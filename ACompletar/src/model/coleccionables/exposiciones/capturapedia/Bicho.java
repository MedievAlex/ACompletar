package model.coleccionables.exposiciones.capturapedia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Bicho extends Capturapedia implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String obtencion;
    private ArrayList<String> condicion;
    

    public Bicho(String nombre, HashMap<String, Boolean> temporada, ArrayList<String> horario, String obtencion, ArrayList<String> condicion) {
        super(nombre, temporada, horario);
        this.obtencion = obtencion;
        this.condicion = condicion;
    }

    public String getObtencion() {
        return obtencion;
    }

    public ArrayList<String> getCondicion() {
        return condicion;
    }

	@Override
	public String toString() {
		return super.toString() + "\n   | Obtencion: " + obtencion + "\n   | Condicion: " + condicion;
	}
}
