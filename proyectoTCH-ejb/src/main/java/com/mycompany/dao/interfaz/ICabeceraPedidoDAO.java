/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.interfaz;

import com.mycompany.entity.TBCabeceraPedido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dhern
 */


@Local
public interface ICabeceraPedidoDAO {
    
    void crear(TBCabeceraPedido entidad);
     
     List<TBCabeceraPedido> buscarTodo();
     
     List<TBCabeceraPedido> buscarCabeceraPedido(TBCabeceraPedido c);
     
     void eliminarPorId(long entidadID);
     
     void eliminar(TBCabeceraPedido entidad);
     
     TBCabeceraPedido buscarPorId(long id);
     
     TBCabeceraPedido actualizar(TBCabeceraPedido entidad);
    
}
