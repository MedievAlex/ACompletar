package model.coleccionables.exposiciones.capturapedia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Submarino extends Capturapedia implements Serializable {

	private static final long serialVersionUID = 1L;

    public Submarino(String nombre, HashMap<String, Boolean> temporada, ArrayList<String> horario) {
        super(nombre, temporada, horario);
    }
    
    @Override
   	public String toString() {
   		return super.toString();
   	}
}

