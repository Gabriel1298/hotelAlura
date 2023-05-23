package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Reserva;

public class ReservaDao {
	final Connection connection;

	public ReservaDao(Connection connection) {
		this.connection = connection;
	}

	public void guardar(Reserva reserva) {
		String sqlQ = "INSERT INTO reservas (fechaE,fechaS,valor,formaPago) VALUE (?,?,?,?)";
		try(PreparedStatement state = this.connection.prepareStatement(sqlQ,Statement.RETURN_GENERATED_KEYS)) {
			

			state.setDate(1, reserva.getFechaE());
			state.setDate(2, reserva.getFechaS());
			state.setString(3, reserva.getValor());
			state.setString(4, reserva.getFormaPago());
			
			state.executeUpdate();
			
			try(ResultSet result = state.getGeneratedKeys()) {
				if(result.next()) {
					reserva.setId(result.getInt(1));
				}
				
			}
			this.connection.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage()+" Error en ReservaDao");
		}

	}
	
	public List<Reserva> listar(){
		List<Reserva> resultado = new ArrayList<Reserva>();
		try {
			PreparedStatement state = this.connection.prepareStatement("SELECT * FROM reservas");
			ResultSet result = state.executeQuery();
			try(result){
				while(result.next()) {
					resultado.add(new Reserva(result.getInt("id"),result.getDate("fechaE"),result.getDate("fechaS"),result.getString("valor"),result.getString("formapago")));
				}
			}

			return resultado;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}
	
	public Reserva buscar(int id) {
		Reserva valor = new Reserva();
		try {
			PreparedStatement state = this.connection.prepareStatement("SELECT * FROM reservas WHERE id=?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			this.connection.commit();
			if(result.next()) {
				return valor = new Reserva(result.getInt("id"),result.getDate("fechaE"),result.getDate("fechaS"),result.getString("valor"),result.getString("formapago"));
			
			}
			System.out.println("si");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return valor;
		
	}
	
	public void eliminar(int id){
		try {
			final PreparedStatement state1 = this.connection.prepareStatement("SELECT * FROM reservas WHERE id=?");
			try(state1){
				state1.setInt(1, id);
				ResultSet result = state1.executeQuery();
				if(result.next()) {
					System.out.println("si existe el objeto con el id: " + id);
					PreparedStatement state2 = this.connection.prepareStatement("delete from reservas where id=?");
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
	
	/*public List<Reserva> listarPorhuesped(int id){
		List<Reserva> resultado = new ArrayList<Reserva>();
		try {
			PreparedStatement state = this.connection.prepareStatement("SELECT * FROM reservas WHERE idHuesped=?");
			state.setInt(1, id);
			ResultSet result = state.executeQuery();
			try(result){
				while(result.next()) {
					resultado.add(new Reserva(result.getInt("id"),result.getDate("fechaE"),result.getDate("fechaS"),result.getString("valor"),result.getString("formapago"),result.getInt("idHuesped")));
				}
			}

			return resultado;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}
	*/
	
	
	public void actualizar(Reserva reserva) {
		String query ="UPDATE reservas SET fechaE = ?, fechaS=?, valor=?, formaPago=? WHERE id = ? ";
		try {
			PreparedStatement state = this.connection.prepareStatement(query);

			try(state){
				state.setDate(1, reserva.getFechaE());
				state.setDate(2, reserva.getFechaS());
				state.setString(3, reserva.getValor());
				state.setString(4, reserva.getFormaPago());
				state.setInt(5,reserva.getId());
				
				state.execute();
				
				this.connection.commit();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);		}
		
	}
	
	public List<Reserva> buscarReservaPorApellidoDeHuesped(String apellido){
		List<Reserva> resultado = new ArrayList<Reserva>();
		String srt = "SELECT reservas.* FROM reservas JOIN huespedes ON reservas.id = huespedes.idReserva WHERE huespedes.apellido = ?";
		try {
			
			PreparedStatement state = this.connection.prepareStatement(srt);
			state.setString(1,apellido);
			ResultSet result = state.executeQuery();
			try(result){
				while(result.next()) {
					resultado.add(new Reserva(result.getInt("id"),result.getDate("fechaE"),result.getDate("fechaS"),result.getString("valor"),result.getString("formapago")));
				}
			}

			return resultado;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.err.println(e.getLocalizedMessage());
			System.out.println("Error en ReservaDao - buscarReservaPorApellidoDeHuesped()");
		}
		return resultado;
	}
	
	 

}
