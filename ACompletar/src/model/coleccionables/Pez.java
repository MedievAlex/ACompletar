/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.coleccionables;

import java.util.HashMap;
import model.*;

/**
 *
 * @author 2dami
 */
public class Pez {

    private final String nombre;
    private final HashMap<String, Boolean> temporada;
    private final String horiario;
    private final Habitad habitad;
    private final Frecuencia frecuencia;
    private boolean obtenido;
    private boolean donado;

    public Pez(String nombre, HashMap<String, Boolean> temporada, String horario, Habitad habitad, Frecuencia frecuencia) {
        this.nombre = nombre;
        this.temporada = temporada;
        this.horiario = horario;
        this.habitad = habitad;
        this.frecuencia = frecuencia;
        this.obtenido = false;
        this.donado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, Boolean> getTemporada() {
        return temporada;
    }

    public String getHoriario() {
        return horiario;
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
