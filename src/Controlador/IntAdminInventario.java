/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dicky
 */
public interface IntAdminInventario {
  
  void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
  void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
  void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
  void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException;
  void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
  void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
  void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
  void denegar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
}
