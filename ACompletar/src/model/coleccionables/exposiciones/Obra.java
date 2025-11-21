package model.coleccionables.exposiciones;

import java.io.Serializable;

import model.TipoObra;

public class Obra extends Exposicion implements Serializable { 

	private static final long serialVersionUID = 1L;
	        
    private String nombre;
    private String descripcion;
    private String autor;
    private TipoObra tipo;

    public Obra(String nombre, String descripcion, String autor, TipoObra tipo) {
    	super(nombre);
    	this.descripcion = descripcion;
    	this.autor = autor;
    	this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
		return descripcion;
	}

	public String getAutor() {
		return autor;
	}

	public TipoObra getTipoObra() {
        return tipo;
    }

	@Override
	public String toString() {
		return super.toString() + "\n   | Descripcion: " + descripcion  + "\n   | Autor: " + autor + "\n   | Tipo de Obra: " + tipo;
	}
}
