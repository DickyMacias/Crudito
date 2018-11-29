/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author dicky
 */
public class Usuario {
  
  String tipo;

  public Usuario(String tipo) {
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  
  public boolean isAdmin(String tipo){
  
    //Se abre un trycatch para revisar si hay un error
    try {
      //Se convierte lo que hay en el campo valor y edad a numerico
      int s = Integer.parseInt(tipo);
      
    } catch (NumberFormatException n) {
      //Si no es numerico regresa un falso
      return false;
    }
    //Si es numerico regresa un true.
    return true;
  }
  
  
  
}
