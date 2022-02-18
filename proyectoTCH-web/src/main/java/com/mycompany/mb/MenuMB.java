/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mb;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dhern
 */

@Named(value = "Menu")
@ManagedBean
@SessionScoped
@Getter
@Setter
public class MenuMB implements Serializable{
    
    public String ingreasarUusario (){
        String Direccion = "verUsuarios.xhtml?faces-redirect=true";
        return Direccion;
    }
    
    
     
    public String ingreasarVerPedido (){
        String Direccion = "verPedidos.xhtml?faces-redirect=true";
        return Direccion;
    }
    
    public String cerrarSesion (){
        String Direccion = "inicioSesion.xhtml?faces-redirect=true";
        return Direccion;
    }
}
