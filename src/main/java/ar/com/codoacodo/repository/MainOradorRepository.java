package ar.com.codoacodo.repository;

import java.time.LocalDateTime;

import ar.com.codoacodo.entity.Orador;

public class MainOradorRepository {

	 public static void main(String[] args) {
		
		 //Interface i = new ClaseQueImplementa();
		 OradorRepository repository = new MySqlOradorRepository();
		 
		 Orador newOrador = new Orador("Martín", "Caloia", "mcaloia@email.com", "escafoides", LocalDateTime.now());
		 repository.save(newOrador);
		 
	//	 repository.save(new Orador);
		 
	//	 Orador newOrador = repository.getById(3L);
		 System.out.println(newOrador);
	}
}