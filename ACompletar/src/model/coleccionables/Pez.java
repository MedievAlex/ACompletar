package model.coleccionables;

import java.io.Serializable;
import java.util.HashMap;

import model.*;

public class Pez extends SerVivo implements Serializable {

	private static final long serialVersionUID = 1L;

    private final Habitad habitad;
    private final Frecuencia frecuencia;

    public Pez(String nombre, HashMap<String, Boolean> temporada, String horario, Habitad habitad, Frecuencia frecuencia) {
        super(nombre, temporada, horario);
        this.habitad = habitad;
        this.frecuencia = frecuencia;
    }

    public Habitad getHabitad() {
        return habitad;
    }

    public Frecuencia getFrecuencia() {
        return frecuencia;
    }
    
    @Override
   	public String toString() {
   		return super.toString() +" | Habitad: " + habitad + " | Frecuencia: " + frecuencia;
   	}
}
