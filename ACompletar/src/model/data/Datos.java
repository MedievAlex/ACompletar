package model.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import model.Frecuencia;
import model.Habitad;
import model.TipoColor;
import model.TipoObra;
import model.coleccionables.Coleccionable;
import model.coleccionables.Color;
import model.coleccionables.Flor;
import model.coleccionables.Giroide;
import model.coleccionables.exposiciones.Fosil;
import model.coleccionables.exposiciones.Fragmento;
import model.coleccionables.exposiciones.Obra;
import model.coleccionables.exposiciones.capturapedia.Bicho;
import model.coleccionables.exposiciones.capturapedia.Pez;
import model.coleccionables.exposiciones.capturapedia.Submarino;

public class Datos {

	private static ObjectOutputStream oos = null; // Escritura
	private static HashMap<String, Boolean> temporada;

        public Datos(){
            
        }
        
	//***Carga los datos de los coleccionables******************************************************************************************/
	public void loadData(ArrayList<File> ficheros) {

		ArrayList<Coleccionable> bichos = loadBichos(ficheros.get(1));
		ArrayList<Coleccionable> peces = loadPeces(ficheros.get(2));
		ArrayList<Coleccionable> submarinos = loadSubmarinos(ficheros.get(3));
		ArrayList<Coleccionable> fosiles = loadFosiles(ficheros.get(4));
		ArrayList<Coleccionable> obras = loadObras(ficheros.get(5));

		ArrayList<Coleccionable> giroides = loadGiroides(ficheros.get(6));
                ArrayList<Coleccionable> flores = loadFlores(ficheros.get(7));

		try {
			oos = new ObjectOutputStream(new FileOutputStream(ficheros.get(0))); // Escritura
			oos.writeObject(bichos);
			oos.writeObject(peces);
			oos.writeObject(submarinos);
			oos.writeObject(fosiles);
			oos.writeObject(obras);
			oos.close(); // Escritura (CERRAR)
		} catch (FileNotFoundException e) { // Excepcion no se ha encontrado el Fichero
			e.printStackTrace();
		} catch (IOException e) { // Excepcion error al acceder al fichero
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("\n[FATAL ERROR]");
		}
	}

	//***Guarda los datos en los ficheros individuales**********************************************************************************/
	private void guardarDatos(File fichero, ArrayList<Coleccionable> lista) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fichero)); // Escritura
			for (Coleccionable coleccionable : lista) {
				oos.writeObject(coleccionable);
			}
		} catch (FileNotFoundException e) { // Excepcion no se ha encontrado el Fichero
			e.printStackTrace();
		} catch (IOException e) { // Excepcion error al acceder al fichero
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("\n[FATAL ERROR]");
		}
	}

	//***Reinicia el valor de la temporada**********************************************************************************************/
	private HashMap<String, Boolean> reloadTemporada() {
		HashMap<String, Boolean> temporadaVacia = new HashMap<String, Boolean>();

		temporadaVacia.put("Enero", false); // 1
		temporadaVacia.put("Febrero", false); // 2
		temporadaVacia.put("Marzo", false); // 3
		temporadaVacia.put("Abril", false); // 4
		temporadaVacia.put("Mayo", false); // 5
		temporadaVacia.put("Junio", false); // 6
		temporadaVacia.put("Julio", false); // 7
		temporadaVacia.put("Agosto", false); // 8
		temporadaVacia.put("Septiembre", false); // 9
		temporadaVacia.put("Octubre", false); // 10
		temporadaVacia.put("Noviembre", false); // 11
		temporadaVacia.put("Diciembre", false); // 12     

		return temporadaVacia;
	}

	//***Registra el mes en la temporada************************************************************************************************/
	private void loadInTemporada(String mes) {
		temporada.replace(mes, true);
	}

        /****[EXPOSICIONES]*****************************************************************************************************************/
	/****Capturapedia: Bichos***********************************************************************************************************/
	private ArrayList<Coleccionable> loadBichos(File ficheroBichos) {
		ArrayList<Coleccionable> bichos = new ArrayList<Coleccionable>();
		ArrayList<String> horario;
		ArrayList<String> condicion;

		// Abeja melífera
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		horario = new ArrayList<String>();
		horario.add("8:00 - 17:00");
		condicion = new ArrayList<String>();
		condicion.add("Sin lluvia");
		bichos.add(new Bicho("Abeja melífera", temporada, horario, "Cerca de flores", condicion));

		// Araña
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("19:00 - 8:00");
		condicion = new ArrayList<String>();
		condicion.add("Sin condiciones especiales");
		bichos.add(new Bicho("Araña", temporada, horario, "Sacudiendo árboles frutales", condicion));

		// Avispa
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		condicion = new ArrayList<String>();
		condicion.add("5 al día como máximo");
		bichos.add(new Bicho("Avispa", temporada, horario, "Sacudiendo árboles no frutales", condicion));

		// Cangrejo ermitaño
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("19:00 - 8:00");
		condicion = new ArrayList<String>();
		condicion.add("Sin condiciones especiales");
		bichos.add(new Bicho("Cangrejo ermitaño", temporada, horario, "Playas", condicion));

		// Caracol
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		condicion = new ArrayList<String>();
		condicion.add("Con lluvia");
		bichos.add(new Bicho("Caracol", temporada, horario, "Sobre rocas o arbustos", condicion));

		// Chinche
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("24h");
		condicion = new ArrayList<String>();
		condicion.add("Sin lluvia");
		bichos.add(new Bicho("Chinche", temporada, horario, "Cerca de flores", condicion));

		// Chinche acuática gigante
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("19:00 - 8:00");
		condicion = new ArrayList<String>();
		condicion.add("Después de cazar 50 bichos en total");
		bichos.add(new Bicho("Chinche acuática gigante", temporada, horario, "Sobre agua dulce", condicion));

		/*
		// nombre
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add();
		condicion = new ArrayList<String>();
		condicion.add();
		bichos.add(new Bicho("nombre", temporada, horario, "obtencion", condicion));
		*/
		
		guardarDatos(ficheroBichos, bichos);

		return bichos;
	}

	/****Capturapedia: Peces************************************************************************************************************/
	private ArrayList<Coleccionable> loadPeces(File ficheroPeces) {
		ArrayList<Coleccionable> peces = new ArrayList<Coleccionable>();
		ArrayList<String> horario;

		// Amarguillo
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Noviembre");
		loadInTemporada("Diciembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Amarguillo", temporada, horario, Habitad.RIO, Frecuencia.MUCHA));

		// Anguila de listón azul
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Anguila de listón azul", temporada, horario, Habitad.MAR, Frecuencia.FRECUENTE));

		// Arowana
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Arowana", temporada, horario, Habitad.RIO, Frecuencia.POCA));

		// Atún
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Atún", temporada, horario, Habitad.MUELLE, Frecuencia.MUYPOCA));

		// Ayu
		temporada = reloadTemporada();
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Ayu", temporada, horario, Habitad.RIO, Frecuencia.FRECUENTE));

		// Betta
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		peces.add(new Pez("Betta", temporada, horario, Habitad.RIO, Frecuencia.MUYPOCA));

		// Bichir ensillado
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("21:00 - 4:00");
		peces.add(new Pez("Bichir ensillado", temporada, horario, Habitad.RIO, Frecuencia.POCA));

		// Boquerón
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("4:00 - 21:00");
		peces.add(new Pez("Boquerón", temporada, horario, Habitad.MAR, Frecuencia.FRECUENTE));

		// Caballito de mar
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Caballito de mar", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Cacho
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		peces.add(new Pez("Cacho", temporada, horario, Habitad.RIO, Frecuencia.MUCHA));

		// Calamar
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Calamar", temporada, horario, Habitad.MAR, Frecuencia.FRECUENTE));

		// Cangrejo de río
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Cangrejo de río", temporada, horario, Habitad.ESTANQUE, Frecuencia.MUCHA));

		// Cangrejo de Shanghái
		temporada = reloadTemporada();
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Cangrejo de Shanghái", temporada, horario, Habitad.RIO, Frecuencia.POCA));

		// Carpa
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Carpa", temporada, horario, Habitad.ESTANQUE, Frecuencia.FRECUENTE));

		// Carpín
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Carpín", temporada, horario, Habitad.RIO, Frecuencia.MUCHA));

		// Celacanto CON LLUVIA
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Celacanto", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Dorada japonesa
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Dorada japonesa", temporada, horario, Habitad.MAR, Frecuencia.FRECUENTE));

		// Dorado
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("4:00 - 21:00");
		peces.add(new Pez("Dorado", temporada, horario, Habitad.RIO, Frecuencia.MUYPOCA));

		// Eperlano
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Eperlano", temporada, horario, Habitad.RIO, Frecuencia.MUCHA));

		// Esturión
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Esturión", temporada, horario, Habitad.DESEMBOCADURA, Frecuencia.POCA));

		// Gallo
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Gallo", temporada, horario, Habitad.MAR, Frecuencia.MUCHA));

		// Gobio de río
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Gobio de río", temporada, horario, Habitad.RIO, Frecuencia.FRECUENTE));

		// Gupi
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		peces.add(new Pez("Gupi", temporada, horario, Habitad.RIO, Frecuencia.FRECUENTE));

		// Jurel
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Jurel", temporada, horario, Habitad.MAR, Frecuencia.MUCHA));

		// Jurel gigante
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Jurel gigante", temporada, horario, Habitad.MUELLE, Frecuencia.MUYPOCA));

		// Killi
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Killi", temporada, horario, Habitad.ESTANQUE, Frecuencia.FRECUENTE));

		// Koi
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("16:00h - 9:00h");
		peces.add(new Pez("Koi", temporada, horario, Habitad.ESTANQUE, Frecuencia.POCA));

		// Lampuga
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Lampuga", temporada, horario, Habitad.MUELLE, Frecuencia.MUYPOCA));

		// Leucisco
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Leucisco", temporada, horario, Habitad.RIO, Frecuencia.MUCHA));

		// Locha
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Locha", temporada, horario, Habitad.RIO, Frecuencia.MUCHA));

		// Lubina
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Lubina", temporada, horario, Habitad.MAR, Frecuencia.MUCHA));

		// Lucio
		temporada = reloadTemporada();
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Lucio", temporada, horario, Habitad.RIO, Frecuencia.POCA));

		// Mariposa marina
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Mariposa marina", temporada, horario, Habitad.MAR, Frecuencia.FRECUENTE));

		// Morena
		temporada = reloadTemporada();
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Morena", temporada, horario, Habitad.MAR, Frecuencia.FRECUENTE));

		// Pargo rojo
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Pargo rojo", temporada, horario, Habitad.MAR, Frecuencia.FRECUENTE));

		// Perca
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Perca", temporada, horario, Habitad.RIO, Frecuencia.MUCHA));

		// Perca amarilla
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Perca amarilla", temporada, horario, Habitad.RIO, Frecuencia.MUCHA));

		// Pez ángel
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Pez ángel", temporada, horario, Habitad.RIO, Frecuencia.POCA));

		// Pez arcoíris
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		peces.add(new Pez("Pez arcoíris", temporada, horario, Habitad.RIO, Frecuencia.FRECUENTE));

		// Pez balón
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Pez balón", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Pez cabeza de serpiente
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		peces.add(new Pez("Pez cabeza de serpiente", temporada, horario, Habitad.ESTANQUE, Frecuencia.MUYPOCA));

		// Pez cabeza transparente
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("21:00 - 4:00");
		peces.add(new Pez("Pez cabeza transparente", temporada, horario, Habitad.MAR, Frecuencia.MUYPOCA));

		// Pez caimán
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Pez caimán", temporada, horario, Habitad.ESTANQUE, Frecuencia.MUYPOCA));

		// Pez cirujano
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Pez cirujano", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Pez doctor
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		peces.add(new Pez("Pez doctor", temporada, horario, Habitad.RIO, Frecuencia.FRECUENTE));

		// Pez dorado
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Pez dorado", temporada, horario, Habitad.ESTANQUE, Frecuencia.FRECUENTE));

		// Pez erizo
		temporada = reloadTemporada();
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Pez erizo", temporada, horario, Habitad.MAR, Frecuencia.MUCHA));

		// Pez espada
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Pez espada", temporada, horario, Habitad.MUELLE, Frecuencia.MUYPOCA));

		// Pez globo
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("21:00 - 4:00");
		peces.add(new Pez("Pez globo", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Pez león
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Pez león", temporada, horario, Habitad.MAR, Frecuencia.FRECUENTE));

		// Pez luna
		temporada = reloadTemporada();
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("4:00 - 21:00");
		peces.add(new Pez("Pez luna", temporada, horario, Habitad.MAR, Frecuencia.MUYPOCA));

		// Pez mariposa
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Pez mariposa", temporada, horario, Habitad.MAR, Frecuencia.FRECUENTE));

		// Pez martillo
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Pez martillo", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Pez napoleón
		temporada = reloadTemporada();
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		horario = new ArrayList<String>();
		horario.add("4:00 - 21:00");
		peces.add(new Pez("Pez napoleón", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Pez payaso
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Pez payaso", temporada, horario, Habitad.MAR, Frecuencia.FRECUENTE));

		// Pez remo
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Pez remo", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Pez sierra
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Pez sierra", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Pez sol
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		peces.add(new Pez("Pez sol", temporada, horario, Habitad.RIO, Frecuencia.MUCHA));

		// Pez telescopio
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		peces.add(new Pez("Pez telescopio", temporada, horario, Habitad.ESTANQUE, Frecuencia.FRECUENTE));

		// Piraña
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		horario.add("21:00 - 4:00");
		peces.add(new Pez("Piraña", temporada, horario, Habitad.RIO, Frecuencia.FRECUENTE));

		// Pirarucú
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Pirarucú", temporada, horario, Habitad.RIO, Frecuencia.POCA));

		// Rana
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Rana", temporada, horario, Habitad.ESTANQUE, Frecuencia.FRECUENTE));

		// Ranchú
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		peces.add(new Pez("Ranchú", temporada, horario, Habitad.ESTANQUE, Frecuencia.POCA));

		// Raya
		temporada = reloadTemporada();
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("4:00 - 21:00");
		peces.add(new Pez("Raya", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Rémora
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Rémora", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Renacuajo
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Renacuajo", temporada, horario, Habitad.ESTANQUE, Frecuencia.FRECUENTE));

		// Rodaballo
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Rodaballo", temporada, horario, Habitad.MAR, Frecuencia.MUCHA));

		// Salmón
		temporada = reloadTemporada();
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Salmón", temporada, horario, Habitad.DESEMBOCADURA, Frecuencia.FRECUENTE));

		// Salmón japonés
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Salmón japonés", temporada, horario, Habitad.CASCADA, Frecuencia.POCA));

		// Salmón real
		temporada = reloadTemporada();
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Salmón real", temporada, horario, Habitad.DESEMBOCADURA, Frecuencia.FRECUENTE));

		// Siluro
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Siluro", temporada, horario, Habitad.ESTANQUE, Frecuencia.FRECUENTE));

		// Taimén
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Taimén", temporada, horario, Habitad.CASCADA, Frecuencia.MUYPOCA));

		// Tetra neón
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		peces.add(new Pez("Tetra neón", temporada, horario, Habitad.RIO, Frecuencia.FRECUENTE));

		// Tiburón
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Tiburón", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Tiburón ballena
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Tiburón ballena", temporada, horario, Habitad.MAR, Frecuencia.POCA));

		// Tilapia
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("24h");
		peces.add(new Pez("Tilapia", temporada, horario, Habitad.RIO, Frecuencia.FRECUENTE));

		// Tortuga caparazón blando
		temporada = reloadTemporada();
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Tortuga caparazón blando", temporada, horario, Habitad.RIO, Frecuencia.FRECUENTE));

		// Tortuga mordedora
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("21:00 - 4:00");
		peces.add(new Pez("Tortuga mordedora", temporada, horario, Habitad.RIO, Frecuencia.POCA));

		// Trucha
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Trucha", temporada, horario, Habitad.CASCADA, Frecuencia.POCA));

		// Trucha dorada
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		peces.add(new Pez("Trucha dorada", temporada, horario, Habitad.CASCADA, Frecuencia.MUYPOCA));

		guardarDatos(ficheroPeces, peces);

		return peces;
	}

	/****Capturapedia: Submarinos*******************************************************************************************************/
	private ArrayList<Coleccionable> loadSubmarinos(File ficheroSubmarinos) {
		ArrayList<Coleccionable> submarinos = new ArrayList<Coleccionable>();
		ArrayList<String> horario;

		// Abulón
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		submarinos.add(new Submarino("Abulón", temporada, horario));

		// Alga wakame
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Alga wakame", temporada, horario));

		// Anémona
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Anémona", temporada, horario));

		// Anguila jardinera
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("4:00 - 21:00");
		submarinos.add(new Submarino("Anguila jardinera", temporada, horario));

		// Babosa de mar
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Babosa de mar", temporada, horario));

		// Bellota de mar
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Bellota de mar", temporada, horario));

		// Bogavante 	
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Bogavante", temporada, horario));

		// Buccino
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Buccino", temporada, horario));

		// Buey del Pacífico
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Buey del Pacífico", temporada, horario));

		// Calamar luciérnaga
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		horario = new ArrayList<String>();
		horario.add("21:00 - 4:00");
		submarinos.add(new Submarino("Calamar luciérnaga", temporada, horario));

		// Calamar vampiro
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		submarinos.add(new Submarino("Calamar vampiro", temporada, horario));

		// Camarón boreal
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		submarinos.add(new Submarino("Camarón boreal", temporada, horario));

		// Canasta de flores de Venus
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Canasta de flores de Venus", temporada, horario));

		// Cangrejo boreal
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Cangrejo boreal", temporada, horario));

		// Cangrejo de nieve
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Cangrejo de nieve", temporada, horario));

		// Cangrejo gazami
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Cangrejo gazami", temporada, horario));

		// Cangrejo gigante japonés
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Cangrejo gigante japonés", temporada, horario));

		// Cangrejo herradura
		temporada = reloadTemporada();
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("21:00 - 4:00");
		submarinos.add(new Submarino("Cangrejo herradura", temporada, horario));

		// Caracola espinosa
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Caracola espinosa", temporada, horario));

		// Cerdo de mar
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		submarinos.add(new Submarino("Cerdo de mar", temporada, horario));

		// Erizo de mar
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Erizo de mar", temporada, horario));

		// Erizo lápiz de pizarra
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		submarinos.add(new Submarino("Erizo lápiz de pizarra", temporada, horario));

		// Estrella de mar
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Estrella de mar", temporada, horario));

		// Gusano políclado
		temporada = reloadTemporada();
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		submarinos.add(new Submarino("Gusano políclado", temporada, horario));

		// Isópodo gigante
		temporada = reloadTemporada();
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		horario = new ArrayList<String>();
		horario.add("9:00 - 16:00");
		horario.add("21:00 - 4:00");
		submarinos.add(new Submarino("Isópodo gigante", temporada, horario));

		// Langosta espinosa
		temporada = reloadTemporada();
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("21:00 - 4:00");
		submarinos.add(new Submarino("Langosta espinosa", temporada, horario));

		// Langosta mantis
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		submarinos.add(new Submarino("Langosta mantis", temporada, horario));

		// Langostino tigre
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		submarinos.add(new Submarino("Langostino tigre", temporada, horario));

		// Medusa luna
		temporada = reloadTemporada();
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Medusa luna", temporada, horario));

		// Mejillón
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Mejillón", temporada, horario));

		// Nautilo
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("16:00 - 9:00");
		submarinos.add(new Submarino("Nautilo", temporada, horario));

		// Ostra
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Ostra", temporada, horario));

		// Ostra perlera
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Ostra perlera", temporada, horario));

		// Pepino de mar
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Pepino de mar", temporada, horario));

		// Piña de mar
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Piña de mar", temporada, horario));

		// Pulpo
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Pulpo", temporada, horario));

		// Pulpo paraguas
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Pulpo paraguas", temporada, horario));

		// Taclobo gigante
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Taclobo gigante", temporada, horario));

		// Uva de mar
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Uva de mar", temporada, horario));

		// Vieira
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		horario = new ArrayList<String>();
		horario.add("24h");
		submarinos.add(new Submarino("Vieira", temporada, horario));

		guardarDatos(ficheroSubmarinos, submarinos);

		return submarinos;
	}

	/****Fosiles************************************************************************************************************************/
	private ArrayList<Coleccionable> loadFosiles(File ficheroFosiles) {
		ArrayList<Coleccionable> fosiles = new ArrayList<Coleccionable>();
		ArrayList<Fragmento> fragmentos;

		// FRAGMENTOS MULTIPLES
		// Anquilosaurio  
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo anquilosaurio"));
		fragmentos.add(new Fragmento("Cuerpo anquilosaurio"));
		fragmentos.add(new Fragmento("Cola anquilosaurio"));
		fosiles.add(new Fosil("Anquilosaurio", fragmentos));

		// Archelon   
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cuerpo archelon"));
		fragmentos.add(new Fragmento("Cola archelon"));
		fosiles.add(new Fosil("Archelon", fragmentos));

		// Braquiosaurio   
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo braquiosaurio"));
		fragmentos.add(new Fragmento("Tórax braquiosaurio"));
		fragmentos.add(new Fragmento("Pelvis braquiosaurio"));
		fragmentos.add(new Fragmento("Cola braquiosaurio"));
		fosiles.add(new Fosil("Braquiosaurio", fragmentos));

		// Brontoterio    
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo brontoterio"));
		fragmentos.add(new Fragmento("Cuerpo brontoterio"));
		fragmentos.add(new Fragmento("Cola brontoterio"));
		fosiles.add(new Fosil("Brontoterio", fragmentos));

		// Deinonico    
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cuerpo deinonico"));
		fragmentos.add(new Fragmento("Cola deinonico"));
		fosiles.add(new Fosil("Deinonico", fragmentos));

		// Dientes de sable    
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cuerpo tigre dientes sable"));
		fragmentos.add(new Fragmento("Cola tigre dientes sable"));
		fosiles.add(new Fosil("Dientes de sable", fragmentos));

		// Dimetrodonte     
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo dimetrodonte"));
		fragmentos.add(new Fragmento("Cuerpo dimetrodonte"));
		fosiles.add(new Fosil("Dimetrodonte", fragmentos));

		// Diplodocus      
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo diplodocus"));
		fragmentos.add(new Fragmento("Cuello diplodocus"));
		fragmentos.add(new Fragmento("Tórax diplodocus"));
		fragmentos.add(new Fragmento("Pelvis diplodocus"));
		fragmentos.add(new Fragmento("Cola diplodocus"));
		fragmentos.add(new Fragmento("Punta de cola diplodocus"));
		fosiles.add(new Fosil("Diplodocus", fragmentos));

		// Espinosaurio     
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo espinosaurio"));
		fragmentos.add(new Fragmento("Cuerpo espinosaurio"));
		fragmentos.add(new Fragmento("Cola espinosaurio"));
		fosiles.add(new Fosil("Espinosaurio", fragmentos));

		// Estegosaurio      
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo estegosaurio"));
		fragmentos.add(new Fragmento("Cuerpo estegosaurio"));
		fragmentos.add(new Fragmento("Cola estegosaurio"));
		fosiles.add(new Fosil("Estegosaurio", fragmentos));

		// Iguanodonte       
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo iguanodonte"));
		fragmentos.add(new Fragmento("Cuerpo iguanodonte"));
		fragmentos.add(new Fragmento("Cola iguanodonte"));
		fosiles.add(new Fosil("Iguanodonte", fragmentos));

		// Mamut      
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo mamut"));
		fragmentos.add(new Fragmento("Cuerpo mamut"));
		fosiles.add(new Fosil("Mamut", fragmentos));		

		// Megaloceros       
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Mitad izq. Megaloceros"));
		fragmentos.add(new Fragmento("Mitad derecha megaloceros"));
		fosiles.add(new Fosil("Megaloceros", fragmentos));

		// Oftalmosaurio      
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo oftalmosaurio"));
		fragmentos.add(new Fragmento("Cuerpo oftalmosaurio"));
		fosiles.add(new Fosil("Oftalmosaurio", fragmentos));			

		// Paquicefalosaurio     
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cuerpo paquicefalosaurio"));
		fragmentos.add(new Fragmento("Cola paquicefalosaurio"));
		fosiles.add(new Fosil("Paquicefalosaurio", fragmentos));

		// Parasaurio        
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo parasaurio"));
		fragmentos.add(new Fragmento("Cuerpo parasaurio"));
		fragmentos.add(new Fragmento("Cola parasaurio"));
		fosiles.add(new Fosil("Parasaurio", fragmentos));		

		// Plesiosaurio        
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo plesiosaurio"));
		fragmentos.add(new Fragmento("Torso plesiosaurio"));
		fragmentos.add(new Fragmento("Cola plesiosaurio"));
		fosiles.add(new Fosil("Plesiosaurio", fragmentos));			

		// Pteranodonte 
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Ala izquierda pteranodonte"));
		fragmentos.add(new Fragmento("Cuerpo pteranodonte"));
		fragmentos.add(new Fragmento("Ala derecha pteranodonte"));
		fosiles.add(new Fosil("Pteranodonte", fragmentos));

		// Quetzalcoatlus  
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Ala izquierda quetzalcoatlus"));
		fragmentos.add(new Fragmento("Cuerpo quetzalcoatlus"));
		fragmentos.add(new Fragmento("Ala derecha quetzalcoatlus"));
		fosiles.add(new Fosil("Quetzalcoatlus", fragmentos));

		// Tiranosaurio         
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo tiranosaurio"));
		fragmentos.add(new Fragmento("Cuerpo tiranosaurio"));
		fragmentos.add(new Fragmento("Cola tiranosaurio"));
		fosiles.add(new Fosil("Tiranosaurio", fragmentos));

		// Triceratops         
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Cráneo triceratops"));
		fragmentos.add(new Fragmento("Cuerpo triceratops"));
		fragmentos.add(new Fragmento("Cola triceratops"));
		fosiles.add(new Fosil("Triceratops", fragmentos));

		// FRAGMENTOS ÚNICOS
		fragmentos = new ArrayList<>();
		fragmentos.add(new Fragmento("Único"));

		// Acantostega
		fosiles.add(new Fosil("Acantostega", fragmentos));

		// Ámbar
		fosiles.add(new Fosil("Ámbar", fragmentos));	

		// Amonites
		fosiles.add(new Fosil("Amonites", fragmentos));

		// Anomalocaris
		fosiles.add(new Fosil("Anomalocaris", fragmentos));

		// Arqueoptérix
		fosiles.add(new Fosil("Arqueoptérix", fragmentos));	

		// Australopiteco
		fosiles.add(new Fosil("Australopiteco", fragmentos));	

		// Coprolito
		fosiles.add(new Fosil("Coprolito", fragmentos));

		// Dunkleosteo
		fosiles.add(new Fosil("Dunkleosteo", fragmentos));	

		// Eustenopteron
		fosiles.add(new Fosil("Eustenopteron", fragmentos));

		// Huella de dinosaurio
		fosiles.add(new Fosil("Huella de dinosaurio", fragmentos));

		// Juramaia
		fosiles.add(new Fosil("Juramaia", fragmentos));	

		// Mandíbula de tiburón
		fosiles.add(new Fosil("Mandíbula de tiburón", fragmentos));

		// Myllokunmingia
		fosiles.add(new Fosil("Myllokunmingia", fragmentos));	

		// Trilobites
		fosiles.add(new Fosil("Trilobites", fragmentos));

		guardarDatos(ficheroFosiles, fosiles);

		return fosiles;
	}

	/****Obras de Arte******************************************************************************************************************/
	private ArrayList<Coleccionable> loadObras(File ficheroObras) {
		ArrayList<Coleccionable> obras = new ArrayList<Coleccionable>();

		// CUADROS
		obras.add(new Obra("Bodegón", "Manzanas y naranjas", "Paul Cézanne", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro alegórico", "El nacimiento de Venus", "Sandro Botticelli", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro anatómico", "Hombre de Vitruvio", "Leonardo da Vinci", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro clásico", "La maja vestida", "Francisco de Goya", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro dama", "Un bar del Folies-Bergère", "Édouard Manet", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro detallado", "Ajisai Sōkeizu", "Itō Jakuchū", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro español", "Las meninas", "Diego Velázquez", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro flores", "Girasoles", "Vincent van Gogh", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro holandés", "La ronda de noche", "Rembrandt van Rijn", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro invernal", "Los cazadores en la nieve", "Pieter Brueghel el Viejo", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro japonés", "Otani Oniji III como Yakko Edobei", "Tōshūsai Sharaku", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro literario", "Ofelia", "John Everett Millais", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro naturaleza (dcha.)", "Biombo de Fūjin y Raijin (derecha)", "Tawaraya Sōtatsu", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro naturaleza (izda.)", "Biombo de Fūjin y Raijin (izquierda)", "Tawaraya Sōtatsu", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro ola", "Treinta y seis vistas del monte Fuji", "Katsushika Hokusai", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro orgánico", "Verano", "Giuseppe Arcimboldo", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro romántico", "La Libertad guiando al pueblo", "Eugène Delacroix", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro segadoras", "Las espigadoras", "Jean-François Millet", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro tenebroso", "La isla de los muertos", "Arnold Böcklin", TipoObra.CUADRO));
		obras.add(new Obra("Cuadro vespertino", "El Temerario", "Joseph Mallord William Turner", TipoObra.CUADRO));
		obras.add(new Obra("Paisaje estrellado", "La noche estrellada", "Vincent van Gogh", TipoObra.CUADRO));
		obras.add(new Obra("Paisaje francés", "Tarde de domingo", "Georges Seurat", TipoObra.CUADRO));
		obras.add(new Obra("Retrato heroico", "El niño azul", "Thomas Gainsborough", TipoObra.CUADRO));
		obras.add(new Obra("Retrato holandés", "La lechera", "Johannes Vermeer", TipoObra.CUADRO));
		obras.add(new Obra("Retrato italiano", "La Mona Lisa", "Leonardo da Vinci", TipoObra.CUADRO));
		obras.add(new Obra("Retrato joven", "El sembrador", "Jean-François Millet", TipoObra.CUADRO));
		obras.add(new Obra("Retrato músico", "El pífano", "Édouard Manet", TipoObra.CUADRO));
		obras.add(new Obra("Retrato oriental", "Mujer mirando hacia atrás", "Hishikawa Moronobu", TipoObra.CUADRO));
		obras.add(new Obra("Retrato perla", "La joven de la perla", "Johannes Vermeer", TipoObra.CUADRO));
		obras.add(new Obra("Retrato regio", "La dama del armiño", "Leonardo da Vinci", TipoObra.CUADRO));

		// ESCULTURAS
		obras.add(new Obra("Busto antiguo", "Busto de Nefertiti", "Thutmose", TipoObra.ESCULTURA));
		obras.add(new Obra("Cabeza colosal", "Cabeza colosal olmeca", "Desconocido", TipoObra.ESCULTURA));
		obras.add(new Obra("Estatua alada", "Victoria de Samotracia", "Desconocido", TipoObra.ESCULTURA));
		obras.add(new Obra("Estatua atlética", "Discóbolo", "Mirón de Eléuteras", TipoObra.ESCULTURA));
		obras.add(new Obra("Estatua femenina", "Venus de Milo", "Desconocido", TipoObra.ESCULTURA));
		obras.add(new Obra("Estatua guerrera", "Guerrero de terracota", "Desconocido", TipoObra.ESCULTURA));
		obras.add(new Obra("Estatua majestuosa", "David", "Miguel Ángel", TipoObra.ESCULTURA));
		obras.add(new Obra("Estatua pensativa", "El pensador", "Auguste Rodin", TipoObra.ESCULTURA));
		obras.add(new Obra("Estatua primitiva", "Estatuilla dogu del periodo Jomon", "Desconocido", TipoObra.ESCULTURA));
		obras.add(new Obra("Estatua triunfante", "Rey Kamehameha I", "Thomas Ridgeway Gould", TipoObra.ESCULTURA));
		obras.add(new Obra("Figura materna", "Loba capitolina", "Desconocido", TipoObra.ESCULTURA));
		obras.add(new Obra("Piedra políglota", "Piedra de Rosetta", "Desconocido", TipoObra.ESCULTURA));
		obras.add(new Obra("Urna imponente", "Houmuwu ding", "Desconocido", TipoObra.ESCULTURA));

		guardarDatos(ficheroObras, obras);

		return obras;
	}

	/****[COLECCIONABLES]***************************************************************************************************************/
	/****Giroides***********************************************************************************************************************/
	private ArrayList<Coleccionable> loadGiroides(File ficheroGiroides) {
		ArrayList<Coleccionable> giroides = new ArrayList<Coleccionable>();

		giroides.add(new Giroide("Acolchoida"));
		giroides.add(new Giroide("Agitoide"));
		giroides.add(new Giroide("Aletensoide"));
		giroides.add(new Giroide("Aluminoide"));
		giroides.add(new Giroide("Arcoviol"));
		giroides.add(new Giroide("Arrugandia"));
		giroides.add(new Giroide("Bipoide"));
		giroides.add(new Giroide("Bomboina"));
		giroides.add(new Giroide("Cacharroide"));
		giroides.add(new Giroide("Cascabela"));
		giroides.add(new Giroide("Castañoide"));
		giroides.add(new Giroide("Clavicoina"));
		giroides.add(new Giroide("Dulzoide"));
		giroides.add(new Giroide("Estrujónido"));
		giroides.add(new Giroide("Figaroide"));
		giroides.add(new Giroide("Flopoide"));
		giroides.add(new Giroide("Gomicoida"));
		giroides.add(new Giroide("Hablaseroide"));
		giroides.add(new Giroide("Hidroide"));
		giroides.add(new Giroide("Ladroide"));
		giroides.add(new Giroide("Mirlitoide"));
		giroides.add(new Giroide("Monotoide"));
		giroides.add(new Giroide("Muelloide"));
		giroides.add(new Giroide("Oinkoide"));
		giroides.add(new Giroide("Pinchoide"));
		giroides.add(new Giroide("Platoide"));
		giroides.add(new Giroide("Puntoide"));
		giroides.add(new Giroide("Rasgueoide"));
		giroides.add(new Giroide("Reverberoide"));
		giroides.add(new Giroide("Silboide"));
		giroides.add(new Giroide("Sinusoide"));
		giroides.add(new Giroide("Tetracordia"));
		giroides.add(new Giroide("Varítono"));
		giroides.add(new Giroide("Vibroide"));
		giroides.add(new Giroide("Xilofoide"));
		giroides.add(new Giroide("Zumbínida"));

		guardarDatos(ficheroGiroides, giroides);

		return giroides;
	}
        
        /****Flores*************************************************************************************************************************/
	private ArrayList<Coleccionable> loadFlores(File ficheroFlores) {
		ArrayList<Coleccionable> flores = new ArrayList<Coleccionable>();
                ArrayList<Color> colores;
                
                // Anémonas
                colores = new ArrayList<Color>();
                colores.add(new Color("Rojo", TipoColor.SEMILLA));
                colores.add(new Color("Blanco", TipoColor.SEMILLA));
                colores.add(new Color("Naranja", TipoColor.SEMILLA));
                colores.add(new Color("Rosa", TipoColor.HIBRIDO));
                colores.add(new Color("Azul", TipoColor.HIBRIDO));
                colores.add(new Color("Morado", TipoColor.HIBRIDO));
		flores.add(new Flor("Anémona", colores));
                
                // Cosmos
                colores = new ArrayList<Color>();
                colores.add(new Color("Rojo", TipoColor.SEMILLA));
                colores.add(new Color("Blanco", TipoColor.SEMILLA));
                colores.add(new Color("Amarillo", TipoColor.SEMILLA));
                colores.add(new Color("Naranja", TipoColor.HIBRIDO));
                colores.add(new Color("Rosa", TipoColor.HIBRIDO));
                colores.add(new Color("Negro", TipoColor.HIBRIDO));
		flores.add(new Flor("Cosmos", colores));
                
                // Cristantemos
                colores = new ArrayList<Color>();
                colores.add(new Color("Rojo", TipoColor.SEMILLA));
                colores.add(new Color("Blanco", TipoColor.SEMILLA));
                colores.add(new Color("Amarillo", TipoColor.SEMILLA));
                colores.add(new Color("Naranja", TipoColor.HIBRIDO));
                colores.add(new Color("Rosa", TipoColor.HIBRIDO));
                colores.add(new Color("Negro", TipoColor.HIBRIDO));
		flores.add(new Flor("Cristantemo", colores));
                
                // Jacintos
                colores = new ArrayList<Color>();
                colores.add(new Color("Rojo", TipoColor.SEMILLA));
                colores.add(new Color("Blanco", TipoColor.SEMILLA));
                colores.add(new Color("Amarillo", TipoColor.SEMILLA));
                colores.add(new Color("Naranja", TipoColor.HIBRIDO));
                colores.add(new Color("Rosa", TipoColor.HIBRIDO));
                colores.add(new Color("Azul", TipoColor.HIBRIDO));
                colores.add(new Color("Morado", TipoColor.HIBRIDO));
		flores.add(new Flor("Jacinto", colores));
                
                // Lirios
                colores = new ArrayList<Color>();
                colores.add(new Color("Rojo", TipoColor.SEMILLA));
                colores.add(new Color("Blanco", TipoColor.SEMILLA));
                colores.add(new Color("Amarillo", TipoColor.SEMILLA));
                colores.add(new Color("Naranja", TipoColor.HIBRIDO));
                colores.add(new Color("Rosa", TipoColor.HIBRIDO));
                colores.add(new Color("Negro", TipoColor.HIBRIDO));
		flores.add(new Flor("Lirio", colores));
                
                // Rosas
                colores = new ArrayList<Color>();
                colores.add(new Color("Rojo", TipoColor.SEMILLA));
                colores.add(new Color("Blanco", TipoColor.SEMILLA));
                colores.add(new Color("Amarillo", TipoColor.SEMILLA));
                colores.add(new Color("Naranja", TipoColor.HIBRIDO));
                colores.add(new Color("Rosa", TipoColor.HIBRIDO));
                colores.add(new Color("Morado", TipoColor.HIBRIDO));
                colores.add(new Color("Negro", TipoColor.HIBRIDO));
                colores.add(new Color("Azul", TipoColor.HIBRIDO));
                colores.add(new Color("Oro", TipoColor.HIBRIDO));
		flores.add(new Flor("Rosa", colores));
                
                // Tulipanes
                colores = new ArrayList<Color>();
                colores.add(new Color("Rojo", TipoColor.SEMILLA));
                colores.add(new Color("Blanco", TipoColor.SEMILLA));
                colores.add(new Color("Amarillo", TipoColor.SEMILLA));
                colores.add(new Color("Naranja", TipoColor.HIBRIDO));
                colores.add(new Color("Rosa", TipoColor.HIBRIDO));
                colores.add(new Color("Morado", TipoColor.HIBRIDO));
                colores.add(new Color("Negro", TipoColor.HIBRIDO));
		flores.add(new Flor("Tulipan", colores));
                
                // Violas
                colores = new ArrayList<Color>();
                colores.add(new Color("Rojo", TipoColor.SEMILLA));
                colores.add(new Color("Blanco", TipoColor.SEMILLA));
                colores.add(new Color("Amarillo", TipoColor.SEMILLA));
                colores.add(new Color("Naranja", TipoColor.HIBRIDO));
                colores.add(new Color("Azul", TipoColor.HIBRIDO));
                colores.add(new Color("Morado", TipoColor.HIBRIDO));
		flores.add(new Flor("Viola", colores));

		guardarDatos(ficheroFlores, flores);

		return flores;
	}
}
