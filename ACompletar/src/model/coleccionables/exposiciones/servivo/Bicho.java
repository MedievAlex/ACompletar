package model.coleccionables.exposiciones.servivo;

import java.io.Serializable;
import java.util.HashMap;

public class Bicho extends SerVivo implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String obtencion;
    private final String condicion;
    

    public Bicho(String nombre, HashMap<String, Boolean> temporada, String horario, String obtencion, String condicion) {
        super(nombre, temporada, horario);
        this.obtencion = obtencion;
        this.condicion = condicion;
    }

    public String getObtencion() {
        return obtencion;
    }

    public String getCondicion() {
        return condicion;
    }
}
