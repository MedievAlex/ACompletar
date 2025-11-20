/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.coleccionables;

/**
 *
 * @author 2dami
 */
public class Fragmento { 
        
    private String nombre;
    private boolean obtenido;
    private boolean donado;

    public Fragmento(String nombre) {
        this.nombre = nombre;
        this.obtenido = false;
        this.donado = false;
    }

    public String getNombre() {
        return nombre;
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
