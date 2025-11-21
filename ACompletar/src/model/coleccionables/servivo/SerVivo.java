package model.coleccionables.servivo;

import java.io.Serializable;
import java.util.HashMap;

import model.coleccionables.Coleccionable;

public abstract class SerVivo extends Coleccionable implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean obtenido;
    private boolean donado;
    private final HashMap<String, Boolean> temporada;
    private final String horiario;

    public SerVivo(String nombre, HashMap<String, Boolean> temporada, String horario) {
        super(nombre);
        this.obtenido = false;
        this.donado = false;
        this.temporada = temporada;
        this.horiario = horario;
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
    
    public HashMap<String, Boolean> getTemporada() {
        return temporada;
    }

    public String getHoriario() {
        return horiario;
    }

	@Override
	public String toString() {
		return super.toString() + "\n   | Obtenido: " + obtenido + " | Donado: " + donado + "\n   | Temporada: " + temporada + "\n   | Horiario: " + horiario;
	}
}
