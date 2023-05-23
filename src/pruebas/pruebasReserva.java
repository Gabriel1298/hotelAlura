package pruebas;


import java.sql.Date;




import java.util.List;

import controller.ReservaController;


import modelo.Reserva;

public class pruebasReserva {

	public static void main(String[] args) {
		Date fechaE = java.sql.Date.valueOf("2023-05-14");
		Date fechaS = java.sql.Date.valueOf("2023-05-31");
		Reserva reserva = new Reserva(fechaE,fechaS,"6000","tarjeta débito");
		
		ReservaController controller = new ReservaController();
		controller.guardar(reserva);
		
		//List<Reserva> re = controller.listarPorCliente(1);

		System.out.println("fin");
	}

}
