package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import ar.com.codoacodo.entity.Orador;
import ar.com.codoacodo.repository.MySqlOradorRepository;
import ar.com.codoacodo.repository.OradorRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/orador")
public class NuevoOradorController extends HttpServlet{

	//crear > POST
	protected void doPost(
				HttpServletRequest request, //aca viene lo que manda el usuario 
				HttpServletResponse response /*manda el backend al frontend*/
			) throws ServletException, IOException {
		
		//capturo los parametros enviados por el front
		String json = request.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));//spring
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("mail");
		String tema = request.getParameter("tema");
		String resumen = request.getParameter("resumen");
		
		//creo mi orador con esos paramtros
		Orador nuevo = new Orador(nombre, apellido, email, tema, resumen, LocalDateTime.now());
		
		//ahora por medio del repository guarda en la db
		OradorRepository repository = new MySqlOradorRepository();
		
		repository.save(nuevo);
		
		//ahora respondo al front
		response.getWriter().print("OK");//json
	}

}
