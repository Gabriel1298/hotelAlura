package modelo;

import java.sql.Date;

public class Huesped {
	private int id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String Nacionalidad;
	private String telefono;
	private int idReserva;
	
	
	public Huesped() {
		
	}
	
	
	
	public Huesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, int idReserva) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.Nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva=idReserva;
	}
	public Huesped(int id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, int idReserva) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		Nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva=idReserva;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

		

	
}
