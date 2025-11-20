/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.coleccionables;

import java.util.ArrayList;

/**
 *
 * @author 2dami
 */
public class Fosil {
        
    private String nombre;
    private ArrayList<Fragmento> fragmentos;
    private boolean completo;
    
    public Fosil(String nombre) {
        this.nombre = nombre;
        this.fragmentos = new ArrayList<>();
        this.completo = false;
    }

    public String getNombre() {
        return nombre;
    }
    
    public ArrayList<Fragmento> getFragmentos() {
        return fragmentos;
    }
    
    public void addFragmentos(Fragmento fragmento) {
        this.fragmentos.add(fragmento);
    }
    
    public boolean isCompleto() {
        return completo;
    }
    
    public void setCompleto() {
        
    }
}
