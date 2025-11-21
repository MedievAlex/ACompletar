package model.coleccionables;

import java.io.Serializable;
import java.util.ArrayList;

public class Fosil extends Coleccionable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Fragmento> fragmentos;
    private boolean completo;
    
    public Fosil(String nombre, ArrayList<Fragmento> fragmentos) {
        super(nombre);
        this.fragmentos = fragmentos;
        this.completo = false;
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
        int cantFragmentos = fragmentos.size();
        
        for(Fragmento fragmento : fragmentos) {
        	if(fragmento.isDonado()) {
        		cantFragmentos--;
        	}
        }
        
        if(cantFragmentos == 0) {
        	completo = true;
        }
        else {
        	completo = false;
        }
    }

	@Override
	public String toString() {
		return super.toString() + "\n   | Completo: " + completo + "\n   | Fragmentos: " + fragmentos.toString();
	}
}
