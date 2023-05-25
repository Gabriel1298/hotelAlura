package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.HuespedController;
import controller.ReservaController;
import modelo.Huesped;
import modelo.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import static org.hamcrest.CoreMatchers.nullValue;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;

	
	private ReservaController reservaController;
	
	private HuespedController huespedControler;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		
		this.reservaController = new ReservaController();
		this.huespedControler = new HuespedController();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		
		
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
				
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				llenarHuespedes();

			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		// con la linea 254, 255 y 256 rellenamos las tablas de forma automatica. ------------------------##########
		
		((DefaultTableModel) tbReservas.getModel()).setRowCount(0);
		llenarReservas();
		llenarHuespedes();
		
		//buscar();
		
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((DefaultTableModel) tbHuespedes.getModel()).setRowCount(0);

				if (esLetra(txtBuscar.getText())) {	
					vaciarTabla(tbHuespedes);
					vaciarTabla(tbReservas);
					
					llenarHuespedes(buescarHuespedPorApellido(txtBuscar.getText()));
					llenarReservas(reservaController.buscarReservaPorApellidoDeHuesped(txtBuscar.getText()));
				} else {
					vaciarTabla(tbHuespedes);
					vaciarTabla(tbReservas);
					String str = txtBuscar.getText();
					int idReserva = Integer.valueOf(str);
					llenarHuespedes(buscarHuespedPorIdReserva(idReserva));
					
					
					List<Reserva> reserva = new ArrayList<Reserva>();
					reserva.add(reservaController.buscar(idReserva));
					llenarReservas(reserva);
					
				

				}
				
				if(txtBuscar.getText().isEmpty()) {
					llenarHuespedes();
					llenarReservas();
				}
				
			

			}
		});
		
		
		

		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int filaAEditarReservas = tbReservas.getSelectedRow();
				int filaAEditarHuespedes = tbHuespedes.getSelectedRow();
				
				if(filaAEditarReservas >= 0 ) {
					actualizarTablaReservas();
					vaciarTabla(tbReservas);
					llenarReservas();
					JOptionPane.showMessageDialog(null, "Reserva modificada con éxito.");
				}
				
				if(filaAEditarHuespedes >= 0) {
					actualizarTablaHuesped();
					vaciarTabla(tbHuespedes);
					llenarHuespedes();
					JOptionPane.showMessageDialog(null, "Huesped modificado con éxito.");
				}
				
				
			}
		});
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int valorReserva = tbReservas.getSelectedRow();
				int valorHuesped = tbHuespedes.getSelectedRow();
				
				if(valorReserva >= 0) {
					eliminarReserva();
					vaciarTabla(tbReservas);
					llenarReservas();
					JOptionPane.showMessageDialog(null, "Reserva eliminada con éxito.");
				}
				
				if(valorHuesped >= 0) {
					eliminarHuesped();
					vaciarTabla(tbHuespedes);
					llenarHuespedes();
					JOptionPane.showMessageDialog(null, "Huesped eliminado con éxito.");
				}
			}
		});
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
		
		

	}
	
	
	private List<Reserva> buscarReservas(){
		return this.reservaController.listarReservasTotales();
	}
	
	private void llenarReservas() {
		List<Reserva> listaReservas = buscarReservas();
			try {
				for(Reserva unaReserva : listaReservas) {
					modelo.addRow(
							new Object[]
									{unaReserva.getId(), unaReserva.getFechaE(), unaReserva.getFechaS(),
										unaReserva.getValor(),unaReserva.getFormaPago()});
				}
			}catch(Exception e) {
				throw e;
			}
		
	}
	private void llenarReservas(List<Reserva> lista) {
		List<Reserva> listaReservas = lista;
			try {
				for(Reserva unaReserva : listaReservas) {
					modelo.addRow(
							new Object[]
									{unaReserva.getId(), unaReserva.getFechaE(), unaReserva.getFechaS(),
										unaReserva.getValor(),unaReserva.getFormaPago()});
				}
			}catch(Exception e) {
				throw e;
			}
		
	}
	
	private List<Huesped> buscarHuespedes(){
		return this.huespedControler.listarhuepedTotales();
	}
	
	private void llenarHuespedes() {
		
		List<Huesped> listaHuespedes = buscarHuespedes();
			try {
				for(Huesped unHuesped : listaHuespedes) {
					modeloHuesped.addRow(
							new Object[]
									{unHuesped.getId(),unHuesped.getNombre(),unHuesped.getApellido(),unHuesped.getFechaNacimiento(),unHuesped.getNacionalidad(),unHuesped.getTelefono(),unHuesped.getIdReserva() });
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
				throw e;
			}
		
	}
	private void llenarHuespedes(List<Huesped> hespedes) {
		
		List<Huesped> listaHuespedes = hespedes;
			try {
				for(Huesped unHuesped : listaHuespedes) {
					modeloHuesped.addRow(
							new Object[]
									{unHuesped.getId(),unHuesped.getNombre(),unHuesped.getApellido(),unHuesped.getFechaNacimiento(),unHuesped.getNacionalidad(),unHuesped.getTelefono(),unHuesped.getIdReserva() });
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
				throw e;
			}
		
	}
	
	private void actualizarTablaReservas() {
		
		Reserva reserva = obtenerUnaReservaDeTabla();
		
		this.reservaController.actualizarReserva(reserva);
		
		
	}	
	
	private Reserva obtenerUnaReservaDeTabla() {
		System.out.println( modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()));
		System.out.println("Se desea actualizar la comuna:" +tbReservas.getSelectedColumn() + " y la fila: " + tbReservas.getSelectedRow());
		
		int idReserva = (int) tbReservas.getValueAt(tbReservas.getSelectedRow(), 0); //con esta linea obtengo el ID de la row seleccionada;
		Date fechaEntrada = (Date) tbReservas.getValueAt(tbReservas.getSelectedRow(), 1);
		Date fechaSalida = (Date) tbReservas.getValueAt(tbReservas.getSelectedRow(), 2);
		String montoPagar = (String)  tbReservas.getValueAt(tbReservas.getSelectedRow(), 3);
		String formaPago = (String)  tbReservas.getValueAt(tbReservas.getSelectedRow(), 4);
		
		return new Reserva(idReserva,fechaEntrada,fechaSalida,montoPagar,formaPago);
	}
	
	private void eliminarReserva() {
		Reserva reserva = obtenerUnaReservaDeTabla();
		this.reservaController.borrar(reserva.getId());
	}
	
	private void eliminarHuesped() {
		Huesped huesped = obtenerUnHuespedDeTabla();
		this.huespedControler.borrar(huesped.getId());
	}
	
	private void actualizarTablaHuesped() {
		
		Huesped huesped = obtenerUnHuespedDeTabla();
		
		this.huespedControler.actualizarHuesped(huesped);
		
		
	}
	
	private Huesped obtenerUnHuespedDeTabla() {
		//System.out.println( modelo.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()));
		//System.out.println("Se desea actualizar la comuna:" +tbReservas.getSelectedColumn() + " y la fila: " + tbReservas.getSelectedRow());
		
		int idHuesped = (int) tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 0); //con esta linea obtengo el ID de la row seleccionada;
		String nombre = (String) tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 1);
		String apellido = (String) tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 2);
		Date fechaNacimiento = (Date) tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 3);
		String nacionalidad = (String)  tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 4);
		String telefono = (String)  tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 5);
		int idReserva = (int) tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 6);
		
		return new Huesped(idHuesped,nombre,apellido,fechaNacimiento,nacionalidad,telefono,idReserva);
	}
	
	private void vaciarTabla(JTable tabla) {
		DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		model.setRowCount(0);
		model.fireTableDataChanged();
	}
	
	
	private List<Huesped> buescarHuespedPorApellido(String apellido) {
		return this.huespedControler.buscarApellido(apellido);
	}
	
	
	private List<Huesped> buscarHuespedPorIdReserva(int idReserva) {
		return this.huespedControler.buscarIdReserva(idReserva);
	}
	
	
	private boolean esLetra(String texto) {
		int value1=0;
		int value2=0;
		for(int i=0;i<texto.length();i++) {
			if(texto.matches("\"^[a-zA-Z]+$\"")) {
				value1++;
			}else if(texto.matches("^\\d+$")) {
				value2++;
			}

		}
		if(value1 >0 ) {
			return true;
		}else if(value1 == 0 && value2 > 0) {
			return false;
		}

		return true;
	}
	
	
	
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
