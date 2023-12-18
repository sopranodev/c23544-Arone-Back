package ar.com.codoacodo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.entity.Orador;
import ar.com.codoacodo.utils.DateUtils;

public class MySqlOradorRepository implements OradorRepository {

	public void save(Orador orador) {
		// get del orador para obtener datos

		// 2 - preparo sql: sql injection!
		String sql = "insert into oradores (nombre, apellido, mail, tema, resumen, fecha_alta) values (?,?,?,?,?,?)";

		try(Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getMail());
			statement.setString(4, orador.getTema());
			statement.setString(5, orador.getResumen());
			statement.setTimestamp(6, new java.sql.Timestamp(DateUtils.asTimeStamp(orador.getFechaAlta()).getTime()));

			statement.executeUpdate();// INSERT/UPDATE/DELETE

			ResultSet res = statement.getGeneratedKeys();
			if (res.next()) {
				Long id = res.getLong(1);// aca esta el id
				orador.setId(id);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("No se pudo crear el orador:", e);
		}
	}

	public Orador getById(Long id) {

		String sql = "select id_orador, nombre, apellido, mail, tema, resumen, fecha_alta from oradores where id_orador = ?";

		Orador orador = null;
		try(Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, id);

			ResultSet res = statement.executeQuery();// SELECT

			if (res.next()) {
				Long dbId = res.getLong(1);  
				String nombre = res.getString(2);  
				String apellido = res.getString(3); 
				String email = res.getString(4);
				String tema = res.getString(5);  
				String resumen = res.getString(6);
				LocalDateTime fechaAlta = DateUtils.asLocalDateTime(res.getTimestamp(7)); 
				
			orador = new Orador(dbId, nombre, apellido, email, tema, resumen, fechaAlta);
			}
			
		} catch (Exception e) {
			throw new IllegalArgumentException("No se pudo crear el orador:", e);
		}
		return orador;
	}

	@Override
	public void update(Orador orador) {
		String sql = "update oradores "
				+ "set nombre=?, apellido=?, mail=?, tema=?, resumen=? "
				+ "where id_orador = ?";
		
		//try with resources
		try(Connection con = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getMail());
			statement.setString(4, orador.getTema());
			statement.setString(5, orador.getResumen());
			statement.setLong(6, orador.getId());
			
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo actualizar el orador:", e);
		}
	}

	@Override
	public void delete(Long id) {
		
		String sql = "delete from oradores where id_orador = ?";
		
		//try with resources
		try(Connection con = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setLong(1, id);
			
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo eliminar el orador:", e);
		}
	}

	public List<Orador> findAll() {

		String sql = "select id_orador, nombre, apellido, mail, tema, resumen, fecha_alta from oradores";

		List<Orador> oradores = new ArrayList<>();//se ve bien en spring!
		
		//try with resources
		try(Connection con = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet res = statement.executeQuery();// SELECT
			//hay datos?
			while (res.next()) {
				Long dbId = res.getLong(1);  
				String nombre = res.getString(2);  
				String apellido = res.getString(3);  
				String email = res.getString(4);
				String tema = res.getString(5);  
				String resumen = res.getString(6);
				LocalDateTime fechaAlta = DateUtils.asLocalDateTime(res.getTimestamp(7));  
				
				oradores.add(new Orador(dbId, nombre, apellido, email, tema, resumen, fechaAlta));
			}
			
		} catch (Exception e) {
			throw new IllegalArgumentException("No se pudo crear el orador:", e);
		}
		return oradores;
	}

}
