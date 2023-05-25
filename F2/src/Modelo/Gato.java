package Modelo;

public class Gato extends Mascota{
	
	private String color;
	private Pelo largoPelo;

	public Gato(int id, String nombre, int edad, String dniDueno, String color, Pelo largoPelo) {
		super(id, nombre, edad, dniDueno);
		// TODO Auto-generated constructor stub
		this.color = color;
		this.largoPelo = largoPelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Pelo getLargoPelo() {
		return largoPelo;
	}

	public void setLargoPelo(Pelo largoPelo) {
		this.largoPelo = largoPelo;
	}

	@Override
	public String toString() {
		return "Gato [color=" + color + ", largoPelo=" + largoPelo + ", id=" + id + ", nombre=" + nombre + ", edad="
				+ edad + ", dniDueno=" + dniDueno + "]";
	}
	
	

}
