/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dao.interfaz.IUsuariosDAO;
import com.mycompany.entity.TBUsuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dhern
 */
@Stateless
public class UsuariosDAO extends AbstractDAO<TBUsuarios> implements IUsuariosDAO{
    
    @PersistenceContext(unitName = "persistencia")
    EntityManager en;
    
    public UsuariosDAO() {
        setClaseGenerica(TBUsuarios.class);
    }

    @Override
    public void crear(TBUsuarios entidad) {
        super.crear(entidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TBUsuarios> buscarTodo() {
        return super.buscarTodo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPorId(long entidadID) {
        super.eliminarPorId(entidadID); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(TBUsuarios entidad) {
        super.eliminar(entidad); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TBUsuarios buscarPorId(long id) {
        return super.buscarPorId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TBUsuarios actualizar(TBUsuarios entidad) {
        return super.actualizar(entidad); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public String buscarNombreUsuario(String nomUsuario, Long idUs){
        String validado = "";
        Query query = e.createQuery("select c.nombreUsuario from  TBUsuarios  c where c.nombreUsuario=:nomUsuario and c.idUsuario != :idUs");
        query.setParameter("nomUsuario",nomUsuario);
        query.setParameter("idUs",idUs);
        List<String> list = query.getResultList();
        if (!list.isEmpty()) {
            validado = list.get(0);
        }
        return validado;
    }
    
    @Override
    public TBUsuarios iniciarSesion(TBUsuarios u){
        TBUsuarios usu = null;
        String consulta = "";
        
        try {
            consulta = "Select u from TBUsuarios u where u.nombreUsuario =:nombreusu and u.contrasena=:con";
            Query query = en.createQuery(consulta);
            query.setParameter("nombreusu",u.getNombreUsuario());
            query.setParameter("con",u.getContrasena());
            List<TBUsuarios> lista = query.getResultList();
            if (!lista.isEmpty() ) {
                usu= lista.get(0);
            }
        } catch (Exception e) {
           throw e;
        }
        return usu;
    }
}
