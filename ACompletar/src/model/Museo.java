/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import model.coleccionables.*;
import model.coleccionables.exposiciones.Fosil;
import model.coleccionables.exposiciones.Obra;
import model.coleccionables.exposiciones.capturapedia.Bicho;
import model.coleccionables.exposiciones.capturapedia.Pez;

/**
 *
 * @author 2dami
 */
public class Museo implements Serializable {
    //Variables
    private final ArrayList<Bicho> bichos;
    private final int cantBichos;
    private final ArrayList<Pez> peces;
    private final int cantPeces;
    private final ArrayList<Fosil> fosiles;
    private final int cantFosiles;
    private final ArrayList<Obra> obras;
    private final int cantObras;

    // Constructor
    private Museo(ArrayList<Bicho> bichos, ArrayList<Pez> peces, ArrayList<Fosil> fosiles, ArrayList<Obra> obras) { 
        this.bichos = bichos;
        cantBichos = bichos.size();
        this.peces = peces;
        cantPeces = peces.size();
        this.fosiles = fosiles;
        cantFosiles = fosiles.size();
        this.obras = obras;
        cantObras = obras.size();
    }

    // Seccion Bichos
    public ArrayList<Bicho> getBichos() {
        return bichos;
    }

    public void addBichos(Bicho bicho) {
        this.bichos.add(bicho);
    }

    public int getCantBichos() {
        return cantBichos;
    }

    // Seccion Peces
    public ArrayList<Pez> getPeces() {
        return peces;
    }

    public void addPeces(Pez pez) {
        this.peces.add(pez);
    }

    public int getCantPeces() {
        return cantPeces;
    }

    // Seccion Fosiles
    public ArrayList<Fosil> getFosiles() {
        return fosiles;
    }

    public void addFosiles(Fosil fosil) {
        this.fosiles.add(fosil);
    }

    public int getCantFosiles() {
        return cantFosiles;
    }

    // Seccion Obras de Arte
    public ArrayList<Obra> getObras() {
        return obras;
    }

    public void addObras(Obra obra) {
        this.obras.add(obra);
    }

    public int getCantObras() {
        return cantObras;
    }
}
