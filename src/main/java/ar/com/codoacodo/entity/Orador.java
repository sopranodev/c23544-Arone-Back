package ar.com.codoacodo.entity;

import java.time.LocalDateTime;

public class Orador {
	//atributos: encapsulamiento
	private Long id;
	private String nombre;
	private String apellido;
	private String mail;
	private String tema;
	private LocalDateTime fechaAlta;
	
	//constructor/es
	//usar cuando voy a enviar un objeto a la db
	//insert into orador (campos,..) values(...)
	public Orador(String nombre, String apellido, String mail, String tema, LocalDateTime fechaAlta) {
		init(nombre, apellido, mail, tema, fechaAlta);
		//alt+shit+m
	}
	//alt+shit+s

	public Orador(Long id, String nombre, String apellido, String mail, String tema, LocalDateTime localDateTime) {
		this.id = id;
		init(nombre, apellido, mail, tema, localDateTime);
	}
	
	private void init(String nombre, String apellido, String mail, String tema, LocalDateTime localDateTime) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.tema = tema;
		this.fechaAlta = localDateTime;
	}

	//otra forma de polimorfismo: SOBREESCRITURA, un metodo que existe en una clase base (java.lang.Object) 
	// pero su hijo (Orador) la cambia
	public String toString() {
		return "Orador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", tema="
				+ tema + ", fechaAlta=" + fechaAlta + "]";
	}	
	
	//cambiar un metodo llamado toString() de la clase Object para ver mas lindo en la consola los atributos
	//del objeto
	//alt+shit+s
	
	//getters/setters
	public Long getId() {
		return this.id;
	}
	/*
	public void setId(Long id) {
		this.id = id;
	}
	*/
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre != null) { 
			this.nombre = nombre;
		}else {
			this.nombre = "N/D";
		}
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		if(apellido != null) { 
			this.apellido = apellido;
		}else {
			this.apellido = "N/D";
		}
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		if(mail != null) { 
			this.mail = mail;
		}else {
			this.mail = "N/D";
		}
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		if(tema != null) { 
			this.tema = tema;
		}else {
			this.tema = "N/D";
		}
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
