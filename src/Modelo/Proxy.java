/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.DAO;
import DAO.ProductoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dicky
 */
public class Proxy implements DAO{
  
  private DAO dao;
  private Usuario usuario;

  public Proxy(DAO dao, Usuario usuario) {
    this.dao = dao;
    this.usuario = usuario;
  }
  

  @Override
  public List<Producto> consultar() throws SQLException {
    this.dao.consultar();
    return null;
  }

  @Override
  public boolean crear(Producto producto) throws SQLException {
    this.dao.crear(producto);
    return false;
  }

  @Override
  public Producto consultarID(int id) throws SQLException {
    this.dao.consultarID(id);
    return null;
  }

  @Override
  public boolean actualizar(Producto producto) throws SQLException {
    this.dao.actualizar(producto);
    return false;
  }

  @Override
  public boolean eliminar(Producto producto) throws SQLException {
    this.dao.eliminar(producto);
    return false;
  }
  
  
  
  
  
}
