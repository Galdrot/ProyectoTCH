/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicios;

import com.mycompany.dao.interfaz.IPedidoDAO;
import com.mycompany.entity.TBCabeceraPedido;
import com.mycompany.entity.TBPedido;
import com.mycompany.servicios.interfaz.IPedidoServicio;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dhern
 */
@Stateless
public class PedidoServicio implements IPedidoServicio {

    @PersistenceContext(unitName = "persistencia")
    EntityManager en;

    @EJB
    private IPedidoDAO pedidoDAO;

    @Override
    public void crearPedido(TBPedido p) {

        pedidoDAO.crear(p);
    }
    
    
    @Override
    public void crearPedidoPorBatch(List<TBPedido> listaPedidos) throws SQLException {
        pedidoDAO.crearPorBatch(listaPedidos);
    }

    @Override
    public List<TBPedido> verPedidos() {
        return pedidoDAO.buscarTodo();
    }

    @Override
    public TBPedido verPedido(long id) {
        return pedidoDAO.buscarPorId(id);
    }

    @Override
    public void eliminarPedidoID(long id) {
        pedidoDAO.eliminarPorId(id);
    }

    @Override
    public void eliminarPedido(TBPedido p) {
        pedidoDAO.eliminar(p);
    }
    
    public void eliminarPedidosPorIdCabecera(Long id){
        pedidoDAO.eliminarPedidosPorIdCabecera(id);
    }

    @Override
    public void actualizarPedido(TBPedido p) {
        pedidoDAO.actualizar(p);
    }

    @Override
    public List<TBPedido> verPedidosIdCabecera(TBCabeceraPedido id) {
        return pedidoDAO.buscarPorIdCabecera(id);
    }
}
