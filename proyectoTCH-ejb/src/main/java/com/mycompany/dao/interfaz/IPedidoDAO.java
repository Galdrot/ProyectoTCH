/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.interfaz;

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
public interface IPedidoDAO {
    
    void crear(TBPedido entidad);
    
    public void crearPorBatch(List<TBPedido> listaPedido) throws SQLException;
     
     List<TBPedido> buscarTodo();
     
     void eliminarPorId(long entidadID);
     
     void eliminar(TBPedido entidad);
     
     void eliminarPedidosPorIdCabecera(long id);
     
     TBPedido buscarPorId(long id);
     
     TBPedido actualizar(TBPedido entidad);
     
     List<TBPedido> buscarPorIdCabecera(TBCabeceraPedido id);
}
