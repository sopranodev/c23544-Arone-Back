package ar.com.codoacodo.controllers;

public class OradorRequest {
	private String nombre;
	private String apellido;
	private String email;
	private String tema;
	private String resumen;
	
	public OradorRequest() {
		
	}
	public OradorRequest(String nombre, String apellido, String email, String tema, String resumen) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.tema = tema;
		this.resumen = resumen;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String getTema() {
		return tema;
	}
	public String getResumen() {
		return resumen;
	}
	
}
