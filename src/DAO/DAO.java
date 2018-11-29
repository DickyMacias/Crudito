/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Producto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dicky
 */
public interface DAO {
  
  List<Producto> consultar() throws SQLException;
  boolean crear(Producto producto) throws SQLException;
  Producto consultarID(int id) throws SQLException;
  boolean actualizar(Producto producto) throws SQLException;
  boolean eliminar(Producto producto) throws SQLException;
}
