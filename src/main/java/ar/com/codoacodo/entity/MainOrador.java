package ar.com.codoacodo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainOrador {

	public static void main(String[] args) {

		//crear un objeto de la clase orador, que luego se enviara a la db
		Orador nuevoOrador = new Orador("carlos", "lopez", "email@email.com", "JAVA", LocalDateTime.now()); 
		
		
		System.out.println(nuevoOrador);
	}

}
