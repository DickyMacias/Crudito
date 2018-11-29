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
import Modelo.Usuario;


@WebServlet("/proxyAdminInventario")
public class ProxyAdminInventario extends HttpServlet implements IntAdminInventario{
	private static final long serialVersionUID = 1L;
	ProductoDAO productoDAO;
    AdminInventario admin;
    Usuario user;

	public void init() {
		String server = getServletContext().getInitParameter("dbURL");
		String user = getServletContext().getInitParameter("dbUser");
		String pass = getServletContext().getInitParameter("dbPassword");
		try {

			productoDAO = new ProductoDAO(server, user, pass);
		} catch (Exception e) {

		}
	}


	public ProxyAdminInventario() {
		super();
		// TODO Auto-generated constructor stub
	}

    public ProxyAdminInventario(AdminInventario admin, Usuario user) {
      super();
      this.admin = admin;
      this.user = user;
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
			case "denegar":
				denegar(request, response);
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
	
    @Override
	public void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
         this.admin.index(request, response);
	}

    @Override
	public void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		if(this.user.isAdmin(request.getParameter("login"))){
          this.admin.registrar(request, response);
        }else{
          denegar(request, response);
        }
    }
	
    @Override
	public void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		if(this.user.isAdmin(request.getParameter("login"))){
          this.admin.nuevo(request, response);
        }else{
          denegar(request, response);
        }
	}
	
	
    @Override
	public void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
         this.admin.mostrar(request, response);
	}	
	
    @Override
	public void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		if(this.user.isAdmin(request.getParameter("login"))){
          this.admin.showEditar(request, response);
        }else{
          denegar(request, response);
        }
	}
	
    @Override
	public void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(this.user.isAdmin(request.getParameter("login"))){
          this.admin.editar(request, response);
        }else{
          denegar(request, response);
        }
	}
	
    @Override
	public void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		if(this.user.isAdmin(request.getParameter("login"))){
          this.admin.eliminar(request, response);
        }else{
          denegar(request, response);
        }
		
	}
    
    @Override
    public void denegar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
         this.admin.denegar(request, response);
	}
}
