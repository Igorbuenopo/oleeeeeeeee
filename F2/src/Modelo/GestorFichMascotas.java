package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorFichMascotas extends GestorFichMascotasAbstract implements GestorFichMascotasInterface {

	@Override
	public void sacarTXT(ArrayList<Mascota> mascotas) {
		// TODO Auto-generated method stub
		try {
			FileReader fic = new FileReader(path);
			BufferedReader buf = new BufferedReader(fic);
			String linea;
			while ((linea = buf.readLine()) != null) {
				String mascota[] = linea.split(",");

				int id = Integer.valueOf(mascota[1]);
				String nombre = mascota[2];
				int edad = Integer.valueOf(mascota[3]);
				String dniDueno = mascota[6];

				if (mascota[0].equals("P")) {
					String raza = mascota[4];
					boolean pulgas = false;
					if(mascota[5].equals("S")) {
						pulgas = true;
					}
					
					Perro p = new Perro(id, nombre, edad, dniDueno, raza, pulgas);
					mascotas.add(p);
				} else {
					String color = mascota[4];
					
					Pelo largoPelo = null;
					if(mascota[5].equals("L")) {
						largoPelo = Pelo.L;
					}else if(mascota[5].equals("M")){
						largoPelo = Pelo.M;
					}else {
						largoPelo = Pelo.C;
					}
					
					Gato g = new Gato(id, nombre, edad, dniDueno, color, largoPelo);
					mascotas.add(g);
				}
			}

			buf.close();
			fic.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void guardarTXT(ArrayList<Mascota> mascotas) {
		// TODO Auto-generated method stub
		
		try {
			FileWriter fic = new FileWriter(path);
			
			for(int i = 0; i<mascotas.size(); i++) {
				if(mascotas.get(i) instanceof Perro) {
					Perro p = (Perro) mascotas.get(i);
					
					String pulgas = "N";
					if(p.isPulgas()) {
						pulgas = "S";
					}
					
					fic.write("P,"+p.getId()+","+p.getNombre()+","+p.getEdad()+","+p.getRaza()+","+pulgas+","+p.getDniDueno()+"\r\n");
				}else {
					Gato g = (Gato) mascotas.get(i);
					
					fic.write("G,"+g.getId()+","+g.getNombre()+","+g.getEdad()+","+g.getColor()+","+g.getLargoPelo()+","+g.getDniDueno()+"\r\n");
				}
			}

			fic.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
