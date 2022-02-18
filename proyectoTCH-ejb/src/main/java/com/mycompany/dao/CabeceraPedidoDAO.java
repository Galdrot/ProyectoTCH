/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dao.interfaz.ICabeceraPedidoDAO;
import com.mycompany.entity.TBCabeceraPedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author dhern
 */
@Stateless
public class CabeceraPedidoDAO extends AbstractDAO<TBCabeceraPedido> implements ICabeceraPedidoDAO {

    @PersistenceContext(unitName = "persistencia")
    EntityManager en;
    
    public CabeceraPedidoDAO() {
        setClaseGenerica(TBCabeceraPedido.class);
    }

    @Override
    public void crear(TBCabeceraPedido entidad) {
        super.crear(entidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TBCabeceraPedido> buscarTodo() {
        return super.buscarTodo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPorId(long entidadID) {
        super.eliminarPorId(entidadID); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(TBCabeceraPedido entidad) {
        super.eliminar(entidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TBCabeceraPedido buscarPorId(long id) {
        return super.buscarPorId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TBCabeceraPedido actualizar(TBCabeceraPedido entidad) {
        return super.actualizar(entidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TBCabeceraPedido> buscarCabeceraPedido(TBCabeceraPedido c) {

        List<TBCabeceraPedido> lista = null;
        String consulta = "";

        try {
            consulta = "Select c from TBCabeceraPedido c where 1=1 ";
            if (c.getIdCabecera() != null && c.getIdCabecera() != 0) {
                consulta = consulta + "and c.idCabecera =:id ";
            }if (c.getFechaPedido() != null) {
                consulta = consulta + "and c.fechaPedido =:fecha ";
            }if (!StringUtils.isBlank(c.getIdentificacionCliente())) {
                consulta = consulta +"and c.identificacionCliente = :iden";
            }
            
            Query query = en.createQuery(consulta);
            
            if (c.getIdCabecera() != null && c.getIdCabecera() != 0) {
                query.setParameter("id", c.getIdCabecera());
            }if (c.getFechaPedido() != null) {
                query.setParameter("fecha", c.getFechaPedido());
            }if (!StringUtils.isBlank(c.getIdentificacionCliente())) {
                query.setParameter("iden", c.getIdentificacionCliente());
            }
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;

    }
}
