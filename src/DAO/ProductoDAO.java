package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Producto;
import Modelo.Singleton;


public class ProductoDAO{
	private Singleton con;
	private Connection connection;

	public ProductoDAO(String server, String user, String pass) throws SQLException {
		con = new Singleton(server, user, pass);
	}

	public boolean crear(Producto producto) throws SQLException {
		String sql = "INSERT INTO inventario (id, codigo, nombre, descripcion, existencia, precio) VALUES (?,?,?,?,?,?)";
		con.conectar();
		connection = con.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, producto.getCodigo());
		statement.setString(3, producto.getNombre());
		statement.setString(4, producto.getDescripcion());
		statement.setDouble(5, producto.getExistencia());
		statement.setDouble(6, producto.getPrecio());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}


	public List<Producto> consultar() throws SQLException {

		List<Producto> listaProductos = new ArrayList<Producto>();
		String sql = "SELECT * FROM inventario";
		con.conectar();
		connection = con.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			int id = rs.getInt("id");
			String codigo = rs.getString("codigo");
			String nombre = rs.getString("nombre");
			String descripcion = rs.getString("descripcion");
			Double existencia = rs.getDouble("existencia");
			Double precio = rs.getDouble("precio");
			Producto producto = new Producto(id, codigo, nombre, descripcion, existencia, precio);
			listaProductos.add(producto);
		}
		con.desconectar();
		return listaProductos;
	}

	public Producto consultarID(int id) throws SQLException {
		Producto producto = null;

		String sql = "SELECT * FROM inventario WHERE id= ? ";
		con.conectar();
		connection = con.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			producto = new Producto(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"),
					rs.getString("descripcion"), rs.getDouble("existencia"), rs.getDouble("precio"));
		}
		rs.close();
		con.desconectar();

		return producto;
	}

	public boolean actualizar(Producto producto) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE inventario SET codigo=?,nombre=?,descripcion=?,existencia=?, precio=? WHERE id=?";
		con.conectar();
		connection = con.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, producto.getCodigo());
		statement.setString(2, producto.getNombre());
		statement.setString(3, producto.getDescripcion());
		statement.setDouble(4, producto.getExistencia());
		statement.setDouble(5, producto.getPrecio());
		statement.setInt(6, producto.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	public boolean eliminar(Producto producto) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM inventario WHERE ID=?";
		con.conectar();
		connection = con.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, producto.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}

}
