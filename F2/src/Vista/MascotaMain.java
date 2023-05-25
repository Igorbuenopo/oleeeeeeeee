package Vista;

import java.util.ArrayList;
import java.util.Scanner;

import Controlador.Metodos;
import Modelo.GestorFichMascotas;
import Modelo.Mascota;

public class MascotaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Metodos m = new Metodos();
		GestorFichMascotas gm = new GestorFichMascotas();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		ArrayList<Mascota> mascotas = new ArrayList<>();

		gm.sacarTXT(mascotas);
		
		do {
			
			opcion = m.validarInt(7, 1, "1. Añadir mascota.\r\n"
					+ "2. Mostrar datos\r\n"
					+ "3. Modificar mascota.\r\n"
					+ "4. Eliminar mascota.\r\n"
					+ "5. Eliminar mascota por DNI del dueño.\r\n"
					+ "6. Buscar mascota por nombre\r\n"
					+ "7. Salir", sc);
			
			switch(opcion) {
			case 1:
				m.anadirMascota(mascotas,sc);
				break;
			case 2:
				m.mostrarDatos(mascotas);
				break;
			case 3: 
				m.modificarDatos(mascotas, sc);
				break;
			case 4:
				m.eliminarMascota(mascotas, sc);
				break;
			case 5:
				m.eliminarMascotaPorDueno(mascotas, sc);
				break;
			case 6:
				m.mostrarDatosPorDueno(mascotas, sc);
			case 7:
				break;
			
			
			}
			
			
		}while(opcion != 7);
		
		gm.guardarTXT(mascotas);
		
		sc.close();
	}

}
