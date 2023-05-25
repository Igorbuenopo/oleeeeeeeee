package Modelo;

public class Perro extends Mascota{
	
	private String raza;
	private boolean pulgas;
	
	public Perro(int id, String nombre, int edad, String dniDueno, String raza, boolean pulgas) {
		super(id, nombre, edad, dniDueno);
		// TODO Auto-generated constructor stub
		this.raza = raza;
		this.pulgas = pulgas;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public boolean isPulgas() {
		return pulgas;
	}

	public void setPulgas(boolean pulgas) {
		this.pulgas = pulgas;
	}

	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", pulgas=" + pulgas + ", id=" + id + ", nombre=" + nombre + ", edad=" + edad
				+ ", dniDueno=" + dniDueno + "]";
	}
	
	

}
