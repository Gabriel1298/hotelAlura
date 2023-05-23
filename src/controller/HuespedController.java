package controller;

import java.sql.Connection;
import java.util.List;

import dao.HuespedDao;
import factory.ConnectionFactory;
import modelo.Huesped;
import modelo.Reserva;

public class HuespedController {
	private Connection connect = new ConnectionFactory().getConnection();
	
	private HuespedDao dao = new HuespedDao(connect);

	public HuespedController() {
		
	}
	

	public void borrar(int id) {
		dao.eliminar(id);
	}
	
	public  Huesped buscar(int id) {
		return dao.buscar(id);
	}
	
	public List<Huesped> listarhuepedTotales(){
		return dao.listar();
	}
	
	public void guardar(Huesped huesped) {
		dao.guardar(huesped);
	}
	
	public void actualizarHuesped(Huesped huesped) {
		dao.actualizarPorId(huesped);
	}
	
	public List<Huesped> buscarApellido(String apellido){
		return dao.buscarApellido(apellido);
	}
	
	
	public List<Huesped> buscarIdReserva(int idReserva){
		return dao.buscarIdReserva(idReserva);
	}
	
}
