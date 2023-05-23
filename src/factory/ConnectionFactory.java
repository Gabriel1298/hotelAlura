package factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.*;

public class ConnectionFactory {
	private DataSource dataSources;
	
	public ConnectionFactory(){
		ComboPooledDataSource pooled = new ComboPooledDataSource();
		pooled.setJdbcUrl("jdbc:mysql://localhost/hotelalura?useTimeZone=true&serverTimeZone=UTC");
		pooled.setUser("root");
		pooled.setPassword("moebius2023");
		pooled.setMaxPoolSize(10);

		this.dataSources= pooled;
	}
	
	public Connection getConnection() {
		try {
			Connection connect = this.dataSources.getConnection();
			connect.setAutoCommit(false);
			return connect;

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
			
	}
}
