/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicios.interfaz;

import com.mycompany.entity.TBCabeceraPedido;
import com.mycompany.entity.TBPedido;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dhern
 */

@Local
public interface IPedidoServicio {
    
    void crearPedido(TBPedido p);
    
    void crearPedidoPorBatch(List<TBPedido> listaPedidos) throws SQLException;
    
    List<TBPedido> verPedidos();
    
    TBPedido verPedido(long id);
    
    void eliminarPedidoID(long id);
   
   void eliminarPedido(TBPedido p);
   
   void eliminarPedidosPorIdCabecera(Long id);
   
   void actualizarPedido(TBPedido p);
   
    public List<TBPedido> verPedidosIdCabecera(TBCabeceraPedido id);
}
