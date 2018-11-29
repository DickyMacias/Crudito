package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    private Connection connection;
    private String server;
    private String user;
    private String pass;
    
    public Singleton(String server, String user, String pass) {
		this.server = server;
		this.user = user;
		this.pass = pass;
	}

	public void conectar() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connection = DriverManager.getConnection(server, user, pass);
        }
    }
     
    public void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

	public Connection getConnection() {
		return connection;
	}  

}
