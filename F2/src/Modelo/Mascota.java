package Modelo;

public abstract class Mascota {
	
	protected int id;
	protected String nombre;
	protected int edad;
	protected String dniDueno;
	
	public Mascota(int id, String nombre, int edad, String dniDueno) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.dniDueno = dniDueno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDniDueno() {
		return dniDueno;
	}

	public void setDniDueno(String dniDueno) {
		this.dniDueno = dniDueno;
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", dniDueno=" + dniDueno + "]";
	}
	
	
}
