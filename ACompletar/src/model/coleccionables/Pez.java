/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.coleccionables;

import java.io.Serializable;
import java.util.HashMap;

import model.*;

/**
 *
 * @author 2dami
 */
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
}
