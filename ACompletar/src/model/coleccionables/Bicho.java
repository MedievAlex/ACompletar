/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.coleccionables;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author 2dami
 */
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
