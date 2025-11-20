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
    private boolean obtenido;
    private boolean donado;

    public Pez(String nombre, HashMap<String, Boolean> temporada, String horario, Habitad habitad, Frecuencia frecuencia) {
        super(nombre, temporada, horario);
        this.habitad = habitad;
        this.frecuencia = frecuencia;
        this.obtenido = false;
        this.donado = false;
    }

    public Habitad getHabitad() {
        return habitad;
    }
    
    public Frecuencia getFrecuencia() {
        return frecuencia;
    }
    
    public boolean isObtenido() {
        return obtenido;
    }

    public void setObtenido(boolean obtenido) {
        this.obtenido = obtenido;
    }

    public boolean isDonado() {
        return donado;
    }

    public void setDonado(boolean donado) {
        this.donado = donado;
    }
}
