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
import model.coleccionables.Coleccionable;
import model.coleccionables.Fosil;
import model.coleccionables.Fragmento;
import model.coleccionables.Obra;
import model.coleccionables.servivo.Bicho;
import model.coleccionables.servivo.Pez;

public class Datos {

	private static ObjectOutputStream oos = null; // Escritura
	private static HashMap<String, Boolean> temporada;

	/****Carga los datos de los coleccionables******************************************************************************************/
	public static void loadData(File ficheroMuseo, File ficheroBichos, File ficheroPeces, File ficheroFosiles, File ficheroObras) {
		ArrayList<Coleccionable> bichos = loadBichos(ficheroBichos);
		ArrayList<Coleccionable> peces = loadPeces(ficheroPeces);
		ArrayList<Coleccionable> fosiles = loadFosiles(ficheroFosiles);
		ArrayList<Coleccionable> obras = loadObras(ficheroObras);

		try {
			oos = new ObjectOutputStream(new FileOutputStream(ficheroMuseo)); // Escritura
			oos.writeObject(bichos);
			oos.writeObject(peces);
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

	/****[EXPOSICIONES: SERES VIVOS]****************************************************************************************************/
	/****Seres Vivos: Bichos************************************************************************************************************/
	private static ArrayList<Coleccionable> loadBichos(File ficheroBichos) {
		temporada = reloadTemporada();

		ArrayList<Coleccionable> bichos = new ArrayList<>();
		Bicho bicho;

		guardarDatos(ficheroBichos, bichos);

		return bichos;
	}

	/****Seres Vivos: Peces*************************************************************************************************************/
	private static ArrayList<Coleccionable> loadPeces(File ficheroPeces) {
		ArrayList<Coleccionable> peces = new ArrayList<>();

		// Amarguillo
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Noviembre");
		loadInTemporada("Diciembre");
		peces.add(new Pez("Amarguillo", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));

		// Anguila de listón azul
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		peces.add(new Pez("Anguila de listón azul", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));

		// Arowana
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Arowana", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.POCA));

		// Atún
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Noviembre");
		peces.add(new Pez("Atún", temporada, "24h", Habitad.MUELLE, Frecuencia.MUYPOCA));

		// Ayu
		temporada = reloadTemporada();
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Ayu", temporada, "24h", Habitad.RIO, Frecuencia.FRECUENTE));

		// Betta
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		peces.add(new Pez("Betta", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.MUYPOCA));

		// Bichir ensillado
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Bichir ensillado", temporada, "21:00 - 4:00", Habitad.RIO, Frecuencia.POCA));

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
		peces.add(new Pez("Boquerón", temporada, "4:00 - 21:00", Habitad.MAR, Frecuencia.FRECUENTE));

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
		peces.add(new Pez("Caballito de mar", temporada, "24h", Habitad.MAR, Frecuencia.POCA));

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
		peces.add(new Pez("Cacho", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.MUCHA));

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
		peces.add(new Pez("Calamar", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));

		// Cangrejo de río
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Cangrejo de río", temporada, "24h", Habitad.ESTANQUE, Frecuencia.MUCHA));

		// Cangrejo de Shanghái
		temporada = reloadTemporada();
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		peces.add(new Pez("Cangrejo de Shanghái", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.POCA));

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
		peces.add(new Pez("Carpa", temporada, "24h", Habitad.ESTANQUE, Frecuencia.FRECUENTE));

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
		peces.add(new Pez("Carpín", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));

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
		peces.add(new Pez("Celacanto", temporada, "24h", Habitad.MAR, Frecuencia.POCA));

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
		peces.add(new Pez("Dorada japonesa", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));

		// Dorado
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Dorado", temporada, "4:00 - 21:00", Habitad.RIO, Frecuencia.MUYPOCA));

		// Eperlano
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Dicienbre");
		peces.add(new Pez("Eperlano", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));

		// Esturión
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		peces.add(new Pez("Esturión", temporada, "24h", Habitad.DESEMBOCADURA, Frecuencia.POCA));

		// Gallo
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		peces.add(new Pez("Gallo", temporada, "24h", Habitad.MAR, Frecuencia.MUCHA));

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
		peces.add(new Pez("Gobio de río", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.FRECUENTE));

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
		peces.add(new Pez("Gupi", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.FRECUENTE));

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
		peces.add(new Pez("Jurel", temporada, "24h", Habitad.MAR, Frecuencia.MUCHA));

		// Jurel gigante
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		peces.add(new Pez("Jurel gigante", temporada, "24h", Habitad.MUELLE, Frecuencia.MUYPOCA));

		// Killi
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		peces.add(new Pez("Killi", temporada, "24h", Habitad.ESTANQUE, Frecuencia.FRECUENTE));

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
		peces.add(new Pez("Koi", temporada, "16:00h - 9:00h", Habitad.ESTANQUE, Frecuencia.POCA));

		// Lampuga
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		peces.add(new Pez("Lampuga", temporada, "24h", Habitad.MUELLE, Frecuencia.MUYPOCA));

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
		peces.add(new Pez("Leucisco", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.MUCHA));

		// Locha
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		peces.add(new Pez("Locha", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));

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
		peces.add(new Pez("Lubina", temporada, "24h", Habitad.MAR, Frecuencia.MUCHA));

		// Lucio
		temporada = reloadTemporada();
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		peces.add(new Pez("Lucio", temporada, "24h", Habitad.RIO, Frecuencia.POCA));

		// Mariposa marina
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Dicienbre");
		peces.add(new Pez("Mariposa marina", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));

		// Morena
		temporada = reloadTemporada();
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		peces.add(new Pez("Morena", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));

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
		peces.add(new Pez("Pargo rojo", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));

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
		peces.add(new Pez("Perca", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));

		// Perca amarilla
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		peces.add(new Pez("Perca amarilla", temporada, "24h", Habitad.RIO, Frecuencia.MUCHA));

		// Pez ángel
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		peces.add(new Pez("Pez ángel", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.POCA));

		// Pez arcoíris
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		peces.add(new Pez("Pez arcoíris", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.FRECUENTE));

		// Pez balón
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		peces.add(new Pez("Pez balón", temporada, "16:00 - 9:00", Habitad.MAR, Frecuencia.POCA));

		// Pez cabeza de serpiente
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		peces.add(new Pez("Pez cabeza de serpiente", temporada, "9:00 - 16:00", Habitad.ESTANQUE, Frecuencia.MUYPOCA));

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
		peces.add(new Pez("Pez cabeza transparente", temporada, "21:00 - 4:00", Habitad.MAR, Frecuencia.MUYPOCA));

		// Pez caimán
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Pez caimán", temporada, "16:00 - 9:00", Habitad.ESTANQUE, Frecuencia.MUYPOCA));

		// Pez cirujano
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Pez cirujano", temporada, "24h", Habitad.MAR, Frecuencia.POCA));

		// Pez doctor
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Pez doctor", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.FRECUENTE));

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
		peces.add(new Pez("Pez dorado", temporada, "24h", Habitad.ESTANQUE, Frecuencia.FRECUENTE));

		// Pez erizo
		temporada = reloadTemporada();
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Pez erizo", temporada, "24h", Habitad.MAR, Frecuencia.MUCHA));

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
		peces.add(new Pez("Pez espada", temporada, "24h", Habitad.MUELLE, Frecuencia.MUYPOCA));

		// Pez globo
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Noviembre");
		loadInTemporada("Dicienbre");
		peces.add(new Pez("Pez globo", temporada, "21:00 - 4:00", Habitad.MAR, Frecuencia.POCA));

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
		peces.add(new Pez("Pez león", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));

		// Pez luna
		temporada = reloadTemporada();
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Pez luna", temporada, "4:00 - 21:00", Habitad.MAR, Frecuencia.MUYPOCA));

		// Pez mariposa
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Pez mariposa", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));

		// Pez martillo
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Pez martillo", temporada, "16:00 - 9:00", Habitad.MAR, Frecuencia.POCA));

		// Pez napoleón
		temporada = reloadTemporada();
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		peces.add(new Pez("Pez napoleón", temporada, "4:00 - 21:00", Habitad.MAR, Frecuencia.POCA));

		// Pez payaso
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Pez payaso", temporada, "24h", Habitad.MAR, Frecuencia.FRECUENTE));

		// Pez remo
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Dicienbre");
		peces.add(new Pez("Pez remo", temporada, "24h", Habitad.MAR, Frecuencia.POCA));

		// Pez sierra
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Pez sierra", temporada, "16:00 - 9:00", Habitad.MAR, Frecuencia.POCA));

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
		peces.add(new Pez("Pez sol", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.MUCHA));

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
		peces.add(new Pez("Pez telescopio", temporada, "9:00 - 16:00", Habitad.ESTANQUE, Frecuencia.FRECUENTE));

		// Piraña
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Piraña", temporada, "9:00 - 16:00 y 21:00 - 4:00", Habitad.RIO, Frecuencia.FRECUENTE));

		// Pirarucú
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Pirarucú", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.POCA));

		// Rana
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		peces.add(new Pez("Rana", temporada, "24h", Habitad.ESTANQUE, Frecuencia.FRECUENTE));

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
		peces.add(new Pez("Ranchú", temporada, "9:00 - 16:00", Habitad.ESTANQUE, Frecuencia.POCA));

		// Raya
		temporada = reloadTemporada();
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		peces.add(new Pez("Raya", temporada, "4:00 - 21:00", Habitad.MAR, Frecuencia.POCA));

		// Rémora
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Rémora", temporada, "24h", Habitad.MAR, Frecuencia.POCA));

		// Renacuajo
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		peces.add(new Pez("Renacuajo", temporada, "24h", Habitad.ESTANQUE, Frecuencia.FRECUENTE));

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
		peces.add(new Pez("Rodaballo", temporada, "24h", Habitad.MAR, Frecuencia.MUCHA));

		// Salmón
		temporada = reloadTemporada();
		loadInTemporada("Septiembre");
		peces.add(new Pez("Salmón", temporada, "24h", Habitad.DESEMBOCADURA, Frecuencia.FRECUENTE));

		// Salmón japonés
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		peces.add(new Pez("Salmón japonés", temporada, "16:00 - 9:00", Habitad.CASCADA, Frecuencia.POCA));

		// Salmón real
		temporada = reloadTemporada();
		loadInTemporada("Septiembre");
		peces.add(new Pez("Salmón real", temporada, "24h", Habitad.DESEMBOCADURA, Frecuencia.FRECUENTE));

		// Siluro
		temporada = reloadTemporada();
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		peces.add(new Pez("Siluro", temporada, "16:00 - 9:00", Habitad.ESTANQUE, Frecuencia.FRECUENTE));

		// Taimén
		temporada = reloadTemporada();
		loadInTemporada("Enero");
		loadInTemporada("Febrero");
		loadInTemporada("Marzo");
		loadInTemporada("Dicienbre");
		peces.add(new Pez("Taimén", temporada, "16:00 - 9:00", Habitad.CASCADA, Frecuencia.MUYPOCA));

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
		peces.add(new Pez("Tetra neón", temporada, "9:00 - 16:00", Habitad.RIO, Frecuencia.FRECUENTE));

		// Tiburón
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Tiburón", temporada, "16:00 - 9:00", Habitad.MAR, Frecuencia.POCA));

		// Tiburón ballena
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Tiburón ballena", temporada, "24h", Habitad.MAR, Frecuencia.POCA));

		// Tilapia
		temporada = reloadTemporada();
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		peces.add(new Pez("Tilapia", temporada, "24h", Habitad.RIO, Frecuencia.FRECUENTE));

		// Tortuga caparazón blando
		temporada = reloadTemporada();
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		peces.add(new Pez("Tortuga caparazón blando", temporada, "16:00 - 9:00", Habitad.RIO, Frecuencia.FRECUENTE));

		// Tortuga mordedora
		temporada = reloadTemporada();
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Julio");
		loadInTemporada("Agosto");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		peces.add(new Pez("Tortuga mordedora", temporada, "21:00 - 4:00", Habitad.RIO, Frecuencia.POCA));

		// Trucha
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Junio");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		peces.add(new Pez("Trucha", temporada, "16:00 - 9:00", Habitad.CASCADA, Frecuencia.POCA));

		// Trucha dorada
		temporada = reloadTemporada();
		loadInTemporada("Marzo");
		loadInTemporada("Abril");
		loadInTemporada("Mayo");
		loadInTemporada("Septiembre");
		loadInTemporada("Octubre");
		loadInTemporada("Noviembre");
		peces.add(new Pez("Trucha dorada", temporada, "16:00 - 9:00", Habitad.CASCADA, Frecuencia.MUYPOCA));

		guardarDatos(ficheroPeces, peces);

		return peces;
	}

	// Reinicia el valor de la temporada
	private static HashMap<String, Boolean> reloadTemporada() {
		HashMap<String, Boolean> temporadaVacia = new HashMap<>();

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
	
	// Registra el mes en la temporada
	private static void loadInTemporada(String mes) {
		temporada.replace(mes, true);
	}
	
	/****Coleccionables: Fosiles********************************************************************************************************/
	private static ArrayList<Coleccionable> loadFosiles(File ficheroFosiles) {
		ArrayList<Coleccionable> fosiles = new ArrayList<>();
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

	// Seccion Obras de Arte
	/****Coleccionables: Obras de Arte**************************************************************************************************/
	private static ArrayList<Coleccionable> loadObras(File ficheroObras) {
		temporada = reloadTemporada();

		ArrayList<Coleccionable> obras = new ArrayList<>();
		Obra obra;

		guardarDatos(ficheroObras, obras);

		return obras;
	}
	
	// Reinicia la lista de temporada


	// Guarda los datos en los ficheros individuales
	private static void guardarDatos(File fichero, ArrayList<Coleccionable> lista) {
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
}
