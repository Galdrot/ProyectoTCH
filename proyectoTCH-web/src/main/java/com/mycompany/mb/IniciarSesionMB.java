/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mb;

import com.mycompany.entity.TBUsuarios;
import com.mycompany.servicios.interfaz.IUsuariosServicio;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dhern
 */
@Named(value = "IniciarSesion")
@ManagedBean
@SessionScoped
@Getter
@Setter
public class IniciarSesionMB implements Serializable {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    @EJB
    private IUsuariosServicio usu;
    private TBUsuarios persona;
    private TBUsuarios valor;

    @PostConstruct
    public void init() {
        this.persona = new TBUsuarios();
    }

    public String validar() {
        String redireccionar = "";
        try {
            valor = this.usu.iniciarSesion(this.persona);
            if (valor != null) {
                redireccionar = "menu.xhtml?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage("fail", new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            }

        } catch (Exception e) {
            throw e;
        }
        return redireccionar;
    }
}
