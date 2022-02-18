/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mb;

import com.mycompany.entity.TBCabeceraPedido;
import com.mycompany.entity.TBPedido;
import com.mycompany.entity.TBTipoMoneda;
import com.mycompany.servicios.interfaz.ICabeceraPedidoServicio;
import com.mycompany.servicios.interfaz.IPedidoServicio;
import com.mycompany.servicios.interfaz.ITipoMonedaServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author dhern
 */
@Named(value = "Pedido")
@ManagedBean
@SessionScoped
@Getter
@Setter
public class PedidoMB implements Serializable {

    @EJB
    private IPedidoServicio ped;
    @EJB
    private ICabeceraPedidoServicio icabPed;
    @EJB
    private ITipoMonedaServicio iTipoMon;

    private List<TBCabeceraPedido> listaCabP;
    private List<TBPedido> pedidosS;
    private List<TBPedido> pedidosSIdCabera;
    private List<TBTipoMoneda> listaMonedas;

    private TBCabeceraPedido cabP;
    private TBPedido pedi;
    private List<TBPedido> editPedi;
    private TBCabeceraPedido editCabP;
    private String estado;

    @PostConstruct
    public void init() {
        this.cabP = new TBCabeceraPedido();
        this.pedi = new TBPedido();
        this.pedidosS = new ArrayList<>();
        cargarMonedas();
    }

    public void Limpiar() {
        this.cabP = new TBCabeceraPedido();
        this.pedidosS = new ArrayList<>();
        this.listaCabP = new ArrayList<>();
    }

    public void onAddNew() {
        // Add one new product to the table:
        TBPedido newProduct = new TBPedido();
        newProduct.setCantidadProducto("0");
        pedidosS.add(newProduct);

        FacesMessage msg = new FacesMessage("Nuevo producto agregado", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void cargarMonedas() {
        listaMonedas = iTipoMon.verTiposMonedas();
    }

    public void onRowEdit(RowEditEvent<TBPedido> event) {
        FacesMessage msg = new FacesMessage("Producto Editado", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<TBPedido> event) {
        FacesMessage msg = new FacesMessage("Cancelado", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void crearPedido() {
        try {
            icabPed.crearOActualizarPedido(cabP, pedidosS, estado);
            long idGuardado = cabP.getIdCabecera();
            Limpiar();
            FacesMessage msg = new FacesMessage("Producto creado", "El codigo de su pedido es " + idGuardado);
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarCabeceraPedido() {
        listaCabP = icabPed.buscarCabeceraPedido(cabP);
    }

    public List<TBPedido> buscarPorIdCabecera(TBCabeceraPedido id) {
        return ped.verPedidosIdCabecera(id);
    }

    public String ingreasarCrearPedido() {
        Limpiar();
        estado = "C";
        String Direccion = "crearPedido.xhtml?faces-redirect=true";
        return Direccion;
    }

    public String ingresarEditarUsuario(TBCabeceraPedido editarP) {
        Limpiar();
        estado = "E";
        cabP = editarP;
        for (TBTipoMoneda moneda : listaMonedas) {
            if (moneda.getIdMoneda() == cabP.getMoneda().getIdMoneda()) {
                cabP.setMoneda(moneda);
            }
        }
        pedidosS = buscarPorIdCabecera(cabP);
        String Direccion = "crearPedido.xhtml?faces-redirect=true";
        return Direccion;
    }

    public void editarPedido() {
        try {
            icabPed.crearOActualizarPedido(cabP, pedidosS, estado);
            long idGuardado = cabP.getIdCabecera();
            FacesMessage msg = new FacesMessage("Modificación Correcta", "El numero de pedido modificado es " + idGuardado);
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gestionarPedido() {
        if (estado.equals("C")) {
            crearPedido();
        } else {
            editarPedido();
        }
    }
    public String cancelar(){
        Limpiar();
        String direccion = "verPedidos.xhtml?faces-redirect=true";
        return direccion;
    }
}
