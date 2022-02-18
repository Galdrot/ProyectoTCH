/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicios.interfaz;

import com.mycompany.entity.TBCabeceraPedido;
import com.mycompany.entity.TBPedido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dhern
 */
@Local
public interface ICabeceraPedidoServicio {
    
    void crearOActualizarPedido(TBCabeceraPedido c, List<TBPedido> listaPedidos, String estado) throws Exception;
    
    List<TBCabeceraPedido> verCabecerasPedidos();
            
    TBCabeceraPedido verCabeceraPedido(long id);
    
    void eliminarCabeceraPedidoID(long id);
    
    void eliminarCabeceraPedido(TBCabeceraPedido c);
    
    void actualizarCabeceraPedido(TBCabeceraPedido c);
    
    List<TBCabeceraPedido> buscarCabeceraPedido(TBCabeceraPedido c);
    
}
