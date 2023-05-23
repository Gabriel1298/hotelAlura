package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import modelo.Huesped;
import modelo.Reserva;

public class HuespedDao {
	final Connection connection;

	public HuespedDao(Connection connection) {
		this.connection = connection;
	}

	public void guardar(Huesped huesped) {
		try {
			PreparedStatement state = this.connection
					.prepareStatement("INSERT INTO huespedes (nombre,apellido,fechaNacimiento,nacionalidad,telefono,idReserva) VALUE (?,?,?,?,?,?)");

			state.setString(1, huesped.getNombre());
			state.setString(2, huesped.getApellido());
			state.setDate(3, huesped.getFechaNacimiento());
			state.setString(4, huesped.getNacionalidad());
			state.setString(5, huesped.getTelefono());
			state.setInt(6,huesped.getIdReserva());
			state.execute();
			this.connection.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage()+" Error en HuespedDao");
		}

	}
	
	public List<Huesped> listar(){
		List<Huesped> resultado = new ArrayList<Huesped>();
		try {
			PreparedStatement state = this.connection.prepareStatement("SELECT * FROM huespedes");
			ResultSet result = state.executeQuery();
			try(result){
				while(result.next()) {
					resultado.add(new Huesped(result.getInt("id"),result.getString("nombre"),result.getString("apellido"),result.getDate("fechaNacimiento"),result.getString("Nacionalidad"),result.getString("telefono"),result.getInt("idReserva")));
				}
			}

			return resultado;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public Huesped buscar(Integer id) {
		Huesped valor = new Huesped();
		try {
			PreparedStatement state = this.connection.prepareStatement("SELECT * FROM huespedes WHERE id=?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			this.connection.commit();
			if(result.next()) {
				return valor = new Huesped(result.getInt("id"),result.getString("nombre"),result.getString("apellido"),result.getDate("fechaNacimiento"),result.getString("Nacionalidad"),result.getString("telefono"),result.getInt("numeroReserva"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return valor;
		
	}
	
	public void eliminar(int id){
		try {
			final PreparedStatement state1 = this.connection.prepareStatement("SELECT * FROM huespedes WHERE id=?");
			try(state1){
				state1.setInt(1, id);
				ResultSet result = state1.executeQuery();
				if(result.next()) {
					System.out.println("si existe el objeto con el id: " + id);
					PreparedStatement state2 = this.connection.prepareStatement("delete from huespedes where id=?");
						state2.setInt(1, id);
						int filasAfectadas = state2.executeUpdate();
						this.connection.commit();
						System.out.println("filas afectadas: "+filasAfectadas); 
				}
			}

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	/*public List<Reserva> listarReservasHuesped(int id){
		List<Reserva> resultado = new ArrayList<Reserva>();
		resultado = new ReservaController().listarPorCliente(id);
		return resultado;
	}
	*/
	
	public void actualizarPorId(Huesped huesped) {
			String query ="UPDATE huespedes SET nombre = ?, apellido=?, fechaNacimiento=?, nacionalidad=?,telefono=?,idReserva=? WHERE id = ? ";
			try {
				PreparedStatement state = this.connection.prepareStatement(query);

				try(state){
					state.setString(1,huesped.getNombre() );
					state.setString(2, huesped.getApellido());
					state.setDate(3, huesped.getFechaNacimiento());
					state.setString(4, huesped.getNacionalidad());
					state.setString(5,huesped.getTelefono());
					state.setInt(6,huesped.getIdReserva());
					state.setInt(7,huesped.getId());
					
					state.execute();
					
					this.connection.commit();
				}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error en HespedDao - actualizarPorId()");
			throw new RuntimeException(e);
			
			}
			
	}
	
	public List<Huesped> buscarApellido(String apellido){
		List<Huesped> resultado = new ArrayList<Huesped>();
		try {
			PreparedStatement state = this.connection.prepareStatement("SELECT * FROM huespedes WHERE apellido=?");
			state.setString(1,apellido);
			ResultSet result = state.executeQuery();
			try(result){
				while(result.next()) {
					resultado.add(new Huesped(result.getInt("id"),result.getString("nombre"),result.getString("apellido"),result.getDate("fechaNacimiento"),result.getString("Nacionalidad"),result.getString("telefono"),result.getInt("idReserva")));
				}
			}

			return resultado;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
		
	}
	
	public List<Huesped> buscarIdReserva(int idRserva){
		List<Huesped> resultado = new ArrayList<Huesped>();
		try {
			PreparedStatement state = this.connection.prepareStatement("SELECT * FROM huespedes WHERE idReserva=?");
			state.setInt(1,idRserva);
			ResultSet result = state.executeQuery();
			try(result){
				while(result.next()) {
					resultado.add(new Huesped(result.getInt("id"),result.getString("nombre"),result.getString("apellido"),result.getDate("fechaNacimiento"),result.getString("Nacionalidad"),result.getString("telefono"),result.getInt("idReserva")));
				}
			}

			return resultado;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	 

}