/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicios;

import com.mycompany.dao.interfaz.ITipoMonedaDAO;
import com.mycompany.entity.TBTipoMoneda;
import com.mycompany.servicios.interfaz.ITipoMonedaServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author dhern
 */

@Stateless
public class TipoMonedaServicio implements ITipoMonedaServicio{
    
    @EJB
    private ITipoMonedaDAO tipoMonedaDAO;
    
    @Override
    public List<TBTipoMoneda> verTiposMonedas(){
        return tipoMonedaDAO.buscarTodo();
    }
    
    @Override
    public TBTipoMoneda verTipoMoneda(long id){
       return tipoMonedaDAO.buscarPorId(id);
    }
    
}
