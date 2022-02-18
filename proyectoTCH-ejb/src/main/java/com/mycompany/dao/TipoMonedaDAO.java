/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dao.interfaz.ITipoMonedaDAO;
import com.mycompany.entity.TBTipoMoneda;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author dhern
 */

@Stateless
public class TipoMonedaDAO extends AbstractDAO<TBTipoMoneda> implements ITipoMonedaDAO{
    
    
    public TipoMonedaDAO() {
        setClaseGenerica(TBTipoMoneda.class);
    }
    
    @Override
    public void crear(TBTipoMoneda entidad) {
        super.crear(entidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TBTipoMoneda> buscarTodo() {
        return super.buscarTodo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPorId(long entidadID) {
        super.eliminarPorId(entidadID); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(TBTipoMoneda entidad) {
        super.eliminar(entidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TBTipoMoneda buscarPorId(long id) {
        return super.buscarPorId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TBTipoMoneda actualizar(TBTipoMoneda entidad) {
        return super.actualizar(entidad); //To change body of generated methods, choose Tools | Templates.
    }
}
