/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mb;

import com.mycompany.entity.TBUsuarios;
import com.mycompany.servicios.interfaz.IUsuariosServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dhern
 */
@Named(value = "Usuarios")
@ManagedBean
@SessionScoped
@Getter
@Setter
public class UsuariosMB implements Serializable{
    
    @EJB
    private IUsuariosServicio usu;
    private List<TBUsuarios> listaPersona;
    private TBUsuarios persona;
    private String estado;
    
    @PostConstruct
    public void init() {
       consultarUsuario();
       this.persona = new TBUsuarios();
       consultarUsuario();
    }
    
    
    public void consultarUsuario(){
        listaPersona = usu.verUsuarios();
    }
    
    public String crearUsuario(){
        
        usu.crearUsuario(persona);
        String Direccion = "verUsuarios.xhtml?faces-redirect=true";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se creo el usuario Correctamente"));
        consultarUsuario();
        return Direccion;
        
    }
    
      public String ingresarCrearUusario(){
        Limpiar();
        estado = "I";
        String Direccion = "crearUsuario.xhtml?faces-redirect=true";
        return Direccion;
    }
      
      public void Limpiar(){
          this.persona = new TBUsuarios();
      }
      
      public String ingresarEditarUsuario(TBUsuarios editarP){
        estado = "E";
        persona = editarP;
        String Direccion = "crearUsuario.xhtml?faces-redirect=true";
        return Direccion;
      }
      public  String gestionarUsuario(){
          String  direccion = "";
          if (estado.equals("I") ) {
              direccion = crearUsuario();
              
          }else{
            direccion =  editarUsuario();
          }
          return direccion;
      }
      public String editarUsuario(){
            String direccion = "";
        try {
            usu.actualizarUsuario(persona);
            direccion = "verUsuarios.xhtml?faces-redirect=true";
            consultarUsuario();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", ex.getMessage()));

        }
        return direccion;
    }
      
      public String eliminarUsuario(){
            String direccion = "";
            usu.eliminarUsuarioID(persona.getIdUsuario());
            direccion = "verUsuarios.xhtml?faces-redirect=true";
            consultarUsuario();
            return direccion;
      }
      public String cancelar(){
        Limpiar();
        String direccion = "verUsuarios.xhtml?faces-redirect=true";
        return direccion;
    }
}
