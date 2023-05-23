package controller;

import java.sql.Connection;
import java.util.List;

import dao.ReservaDao;
import factory.ConnectionFactory;
import modelo.Reserva;

public class ReservaController {
	private Connection connect = new ConnectionFactory().getConnection();
	
	private ReservaDao dao = new ReservaDao(connect);

	public ReservaController() {
		
	}
	
	public void borrar(int id) {
		dao.eliminar(id);
	}
	
	public Reserva buscar(int id) {
		return dao.buscar(id);
	}
	
	public List<Reserva> listarReservasTotales(){
		return dao.listar();
	}
	
	public void guardar(Reserva reserva) {
		 dao.guardar(reserva);
	}
	
	/*public List<Reserva> listarPorCliente(int id){
		return dao.listarPorhuesped(id);
	}*/
	
	public void actualizarReserva(Reserva reserva) {
		this.dao.actualizar(reserva);
	}
	
	public List<Reserva> buscarReservaPorApellidoDeHuesped(String apellido){
		return dao.buscarReservaPorApellidoDeHuesped(apellido);
	}
	
}
