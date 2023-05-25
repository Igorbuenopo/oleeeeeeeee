package Controlador;

import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Gato;
import Modelo.Mascota;
import Modelo.Pelo;
import Modelo.Perro;

public class Metodos {

	public boolean validarDNI(String dni) {
		boolean validado = true;
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		if (dni.length() != 9) {
			validado = false;
		} else {
			int numeros = 0;
			try {
				numeros = Integer.valueOf(dni.substring(0, 8));

			} catch (NumberFormatException e) {
				validado = false;

			}
			char letra = letras.charAt(numeros % 23);
			if (letra != (dni.charAt(8))) {
				validado = false;
			}

		}
		return validado;
	}

	public int validarInt(int max, int min, String texto, Scanner sc) {
		int opcion = 0;
		boolean error = false;

		do {
			System.out.println(texto);
			String opcionS = sc.nextLine();
			error = false;
			
			try {
				opcion = Integer.valueOf(opcionS);

				if (opcion < min || opcion > max) {
					error = true;
					System.out.println("Pon un número entre " + min + " y " + max);
				}
				
				
			} catch (Exception e) {
				error = true;
				System.out.println("Pon un número");
			}

		} while (error);

		return opcion;

	}

	public void anadirMascota(ArrayList<Mascota> mascotas, Scanner sc) {
		// TODO Auto-generated method stub

		int opcion = validarInt(2, 1, "¿Qué animal vas a añadir?\r\n" + "1. Perro\r\n" + "2. Gato\r\n", sc);

		int id = 1;

		if (mascotas.size() != 0) {
			id = generarId(mascotas);
		}

		System.out.println("Pon el nombre de la mascota: ");
		String nombre = sc.nextLine();

		int edad = 0;
		boolean error = false;
		do {
			System.out.println("Escribe la edad de la mascota: ");
			String edadS = sc.nextLine();

			try {

				edad = Integer.valueOf(edadS);
				error = false;
			} catch (Exception e) {
				error = true;
				System.out.println("Pon un número");

			}

		} while (error);

		error = false;
		String dni = "";
		do {

			System.out.println("Escribe el DNI del dueño: ");
			dni = sc.nextLine();
			try {
				error = validarDNI(dni);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("DNI no válido");
			}
		} while (!error);

		if (opcion == 1) {

			System.out.println("Pon la raza de la mascota: ");
			String raza = sc.nextLine();

			boolean pulgas = false;

			int pulgasInt = validarInt(2, 1, "¿Tiene pulgas?\r\n" + "1. Si\r\n" + "2. No\r\n", sc);

			if (pulgasInt == 1) {

				pulgas = true;
			}

			Perro p = new Perro(id, nombre, edad, dni, raza, pulgas);

			mascotas.add(p);

		} else {

			System.out.println("Pon el color de la mascota: ");
			String color = sc.nextLine();

			Pelo largoPelo = null;

			int largoPeloInt = validarInt(3, 1,
					"¿Como tiene el pelo?\r\n" + "1. Largo\r\n" + "2. Medio\r\n" + "3. Corto\r\n", sc);

			if (largoPeloInt == 1) {
				largoPelo = Pelo.L;
			} else if (largoPeloInt == 2) {
				largoPelo = Pelo.M;
			} else {
				largoPelo = Pelo.C;
			}

			Gato g = new Gato(id, nombre, edad, dni, color, largoPelo);
			mascotas.add(g);
		}
	}

	public int generarId(ArrayList<Mascota> mascotas) {
		// TODO Auto-generated method stub
		return mascotas.get(mascotas.size() - 1).getId() + 1;
	}

	public void mostrarDatos(ArrayList<Mascota> mascotas) {
		// TODO Auto-generated method stub

		if (mascotas.size() == 0) {
			System.out.println("No hay ninguna mascota metida");
		} else {
			for (int i = 0; i < mascotas.size(); i++) {

				System.out.println(mascotas.get(i).toString());

			}
		}

	}

	public void modificarDatos(ArrayList<Mascota> mascotas, Scanner sc) {
		// TODO Auto-generated method stub
		if (mascotas.size() == 0) {
			System.out.println("No hay ninguna mascota metida");
		} else {

			System.out.println("Pon un id: ");
			int id = sc.nextInt();

			boolean encontrado = false;
			int i = 0;
			Mascota m = null;
			do {

				if (mascotas.get(i).getId() == id) {
					encontrado = true;
					m = mascotas.get(i);
				}

				i++;
			} while (!encontrado && i < mascotas.size());

			if (m != null) {
				int opcion = validarInt(2, 1, "¿Qué quieres cambiar?\r\n" + "1. Nombre\r\n" + "2. Edad\r\n", sc);

				if (opcion == 1) {
					System.out.println("Pon el nombre de la mascota: ");
					String nombre = sc.nextLine();

					m.setNombre(nombre);
				} else {

					int edad = 0;
					boolean error = false;
					do {
						System.out.println("Escribe la edad de la mascota: ");
						String edadS = sc.nextLine();

						try {

							edad = Integer.valueOf(edadS);
							error = false;
						} catch (Exception e) {
							error = true;
							System.out.println("Pon un número");

						}

					} while (error);

					m.setEdad(edad);

				}
			} else {
				System.out.println("No se ha encontrado ninguna mascota");
			}

		}

	}

	public void eliminarMascota(ArrayList<Mascota> mascotas, Scanner sc) {
		// TODO Auto-generated method stub
		if (mascotas.size() == 0) {
			System.out.println("No hay ninguna mascota metida");
		} else {

			System.out.println("Pon un id: ");
			int id = sc.nextInt();

			boolean encontrado = false;
			int i = 0;
			Mascota m = null;
			do {

				if (mascotas.get(i).getId() == id) {
					encontrado = true;
					m = mascotas.get(i);
				}

				i++;
			} while (!encontrado && i < mascotas.size());

			if (m != null) {
				mascotas.remove(m);
				System.out.println("Se ha eliminado correctamente");
			} else {
				System.out.println("No se ha encontrado ninguna mascota");
			}
		}
	}

	public void eliminarMascotaPorDueno(ArrayList<Mascota> mascotas, Scanner sc) {
		// TODO Auto-generated method stub
		if (mascotas.size() == 0) {
			System.out.println("No hay ninguna mascota metida");
		} else {

			System.out.println("Pon un DNI: ");
			String dni = sc.nextLine();

			for (int i = 0; i < mascotas.size(); i++) {
				if (mascotas.get(i).getDniDueno().equals(dni)) {
					mascotas.remove(mascotas.get(i));
				}
			}

			System.out.println("Se han eliminado todas las mascotas con DNI: " + dni);
		}
	}

	public void mostrarDatosPorDueno(ArrayList<Mascota> mascotas, Scanner sc) {
		// TODO Auto-generated method stub
		String lista = "";

		if (mascotas.size() == 0) {
			System.out.println("No hay ninguna mascota metida");
		} else {

			System.out.println("Pon un DNI: ");
			String dni = sc.nextLine();

			for (int i = 0; i < mascotas.size(); i++) {

				if (mascotas.get(i).getDniDueno().equals(dni)) {
					lista += mascotas.get(i) + "\r\n";
				}

			}

			if (lista.equals("")) {
				System.out.println("No hay ninguna mascota con el DNI: " + dni);
			} else {
				System.out.println(lista);
			}
		}
	}

}
