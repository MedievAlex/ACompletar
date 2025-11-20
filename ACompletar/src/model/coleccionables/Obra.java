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
public class Obra implements Serializable {

    private String nombre;
    private HashMap<String, Boolean> meses;
    private String horiario;
    private boolean obtenido;
    private boolean donado;

    public Obra(String nombre, HashMap<String, Boolean> meses, String horario) {
        this.nombre = nombre;
        this.meses = meses;
        this.horiario = horario;
        this.obtenido = false;
        this.donado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, Boolean> getMeses() {
        return meses;
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
