package Controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductoDAO;
import Modelo.Producto;


@WebServlet("/adminInventario")
public class AdminInventario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoDAO productoDAO;

	public void init() {
		String server = getServletContext().getInitParameter("dbURL");
		String user = getServletContext().getInitParameter("dbUser");
		String pass = getServletContext().getInitParameter("dbPassword");
		try {

			productoDAO = new ProductoDAO(server, user, pass);
		} catch (Exception e) {

		}
	}


	public AdminInventario() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "registrar":
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Producto producto = new Producto(0, request.getParameter("codigo"), request.getParameter("nombre"), request.getParameter("descripcion"), Double.parseDouble(request.getParameter("cantidad")), Double.parseDouble(request.getParameter("precio")));
		productoDAO.crear(producto);
		mostrar(request, response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/registrar.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
		List<Producto> listaProductos= productoDAO.consultar();
		request.setAttribute("lista", listaProductos);
		dispatcher.forward(request, response);
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Producto producto = productoDAO.consultarID(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("producto", producto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Producto producto = new Producto(Integer.parseInt(request.getParameter("id")), request.getParameter("codigo"), request.getParameter("nombre"), request.getParameter("descripcion"), Double.parseDouble(request.getParameter("existencia")), Double.parseDouble(request.getParameter("precio")));
		productoDAO.actualizar(producto);
		mostrar(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Producto producto = productoDAO.consultarID(Integer.parseInt(request.getParameter("id")));
		productoDAO.eliminar(producto);
		mostrar(request, response);
		
	}
}
