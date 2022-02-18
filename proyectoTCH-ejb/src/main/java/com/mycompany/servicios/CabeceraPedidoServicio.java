/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicios;

import com.mycompany.dao.interfaz.ICabeceraPedidoDAO;
import com.mycompany.entity.TBCabeceraPedido;
import com.mycompany.entity.TBPedido;
import com.mycompany.servicios.interfaz.ICabeceraPedidoServicio;
import com.mycompany.servicios.interfaz.IPedidoServicio;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dhern
 */
@Stateless
public class CabeceraPedidoServicio implements ICabeceraPedidoServicio {

    @PersistenceContext(unitName = "persistencia")
    EntityManager en;

    @EJB
    private ICabeceraPedidoDAO cabeceraDao;
    @EJB
    private IPedidoServicio pedidoServicio;

    @Override
    public void crearOActualizarPedido(TBCabeceraPedido c, List<TBPedido> listaPedidos, String estado) throws Exception {
        c.setFechaPedido(new Date());
        if (estado.equals("C")) {//E
            cabeceraDao.crear(c);
        } else {
            cabeceraDao.actualizar(c);
            pedidoServicio.eliminarPedidosPorIdCabecera(c.getIdCabecera());
        }
        for (TBPedido pedido : listaPedidos) {
            pedido.setIdCabecera(c.getIdCabecera());
        }

        pedidoServicio.crearPedidoPorBatch(listaPedidos);

    }

    @Override
    public List<TBCabeceraPedido> verCabecerasPedidos() {
        return cabeceraDao.buscarTodo();
    }

    @Override
    public TBCabeceraPedido verCabeceraPedido(long id) {
        return cabeceraDao.buscarPorId(id);
    }

    @Override
    public void eliminarCabeceraPedidoID(long id) {
        cabeceraDao.eliminarPorId(id);
    }

    @Override
    public void eliminarCabeceraPedido(TBCabeceraPedido c) {
        cabeceraDao.eliminar(c);
    }

    @Override
    public void actualizarCabeceraPedido(TBCabeceraPedido c) {
        cabeceraDao.actualizar(c);
    }

    @Override
    public List<TBCabeceraPedido> buscarCabeceraPedido(TBCabeceraPedido c) {
        return cabeceraDao.buscarCabeceraPedido(c);
    }
}
