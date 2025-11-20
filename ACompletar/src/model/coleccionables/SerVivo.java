package model.coleccionables;

import java.io.Serializable;
import java.util.HashMap;

public abstract class SerVivo extends Coleccionable implements Serializable {
	private static final long serialVersionUID = 1L;

	private final HashMap<String, Boolean> temporada;
    private final String horiario;
	
	public SerVivo(String nombre, HashMap<String, Boolean> temporada, String horario) {
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
}
