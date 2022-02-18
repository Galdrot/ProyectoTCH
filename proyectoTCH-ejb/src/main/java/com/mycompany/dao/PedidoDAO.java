/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dao.interfaz.IPedidoDAO;
import com.mycompany.entity.TBCabeceraPedido;
import com.mycompany.entity.TBPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

/**
 *
 * @author dhern
 */
@Stateless
public class PedidoDAO extends AbstractDAO<TBPedido> implements IPedidoDAO {

    @Resource(mappedName = "jdbc/proyectoTCH")
    DataSource datasource;

    @PersistenceContext(unitName = "persistencia")
    EntityManager en;

    public PedidoDAO() {
        setClaseGenerica(TBPedido.class);
    }

    @Override
    public void crear(TBPedido entidad) {
        super.crear(entidad);
    }

    @Override
    public void crearPorBatch(List<TBPedido> listaPedido) throws SQLException {
        
        String sql;
        
            sql = "Insert into TB_Pedido (codigo_Producto,nombre_Producto,unidad_Producto,cantidad_Producto,valor_Producto,id_Cabecera) "
                + "Values (?,?,?,?,?,?)";
        

        PreparedStatement statement = datasource.getConnection().prepareStatement(sql);
        for (TBPedido pedido : listaPedido) {
            statement.clearParameters();
            statement.setString(1, pedido.getCodigoProducto());
            statement.setString(2, pedido.getNombreProducto());
            statement.setString(3, pedido.getUnidadProducto());
            statement.setString(4, pedido.getCantidadProducto());
            statement.setLong(5, pedido.getValorProducto());
            statement.setLong(6, pedido.getIdCabecera());
            statement.addBatch();

        }
        statement.executeBatch();
        statement.clearBatch();

    }
    @Override
    public List<TBPedido> buscarTodo() {
        return super.buscarTodo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPorId(long entidadID) {
        super.eliminarPorId(entidadID); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(TBPedido entidad) {
        super.eliminar(entidad); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void eliminarPedidosPorIdCabecera(long id){
        String consulta="delete from TBPedido p where p.idCabecera = :id";
        Query query = en.createQuery(consulta);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public TBPedido buscarPorId(long id) {
        return super.buscarPorId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TBPedido actualizar(TBPedido entidad) {
        return super.actualizar(entidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TBPedido> buscarPorIdCabecera(TBCabeceraPedido id) {
        List<TBPedido> lista = null;
        String consulta = "";

        try {
            consulta = "Select p from TBPedido p where p.idCabecera = :id";

            Query query = en.createQuery(consulta);
            query.setParameter("id", id.getIdCabecera());
            lista = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
