package model.coleccionables.exposiciones.servivo;

import java.io.Serializable;
import java.util.HashMap;

import model.Frecuencia;
import model.Habitad;

public class Submarino extends SerVivo implements Serializable {

	private static final long serialVersionUID = 1L;

    public Submarino(String nombre, HashMap<String, Boolean> temporada, String horario) {
        super(nombre, temporada, horario);
    }
    
    @Override
   	public String toString() {
   		return super.toString();
   	}
}

