package pruebas;

import java.sql.Connection;

import java.sql.Date;

import dao.HuespedDao;
import factory.ConnectionFactory;
import modelo.Huesped;
import java.util.List;

public class pruebasHuesped {
	public static void main(String[] args) {
		ConnectionFactory fac = new ConnectionFactory();
		Connection connect = fac.getConnection();
		HuespedDao dao1 = new HuespedDao(connect);
		Date date = java.sql.Date.valueOf("1998-05-12");
		Huesped huesped = new Huesped("Gabriel", "Gonzalez", date, "Argentino", "25",1);
		//dao1.guardar(huesped);
		
		List<Huesped> huespedes =dao1.listar();
		
		for(Huesped hues : huespedes) {
			System.out.println(hues.getId());
		}
		
	}
	
	
}
