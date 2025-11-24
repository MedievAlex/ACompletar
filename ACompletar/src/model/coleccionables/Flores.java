package model.coleccionables;

import java.io.Serializable;
import java.util.ArrayList;

public class Flores  extends Coleccionable implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Color> colores;
    private boolean completo;

    public Flores(String nombre, ArrayList<Color> colores) {
        super(nombre);
        this.colores = colores;
        this.completo = false;
    }
    
    public ArrayList<Color> getColores() {
        return colores;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto() {
        int cantColores = colores.size();

        for (Color color : colores) {
            if (color.isObtenido()) {
                cantColores--;
            }
        }

        if (cantColores == 0) {
            completo = true;
        } else {
            completo = false;
        }
    }  
}
