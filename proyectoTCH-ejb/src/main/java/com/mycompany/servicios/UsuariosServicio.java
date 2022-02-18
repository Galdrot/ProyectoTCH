/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicios;

import com.mycompany.dao.interfaz.IUsuariosDAO;
import com.mycompany.entity.TBUsuarios;
import com.mycompany.servicios.interfaz.IUsuariosServicio;
import java.util.List;
import javax.ejb.EJB;
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
public class UsuariosServicio implements IUsuariosServicio{
    
    @PersistenceContext(unitName = "persistencia")
    EntityManager en;
    
    @EJB
    private IUsuariosDAO usuarioDao;
    
    @Override
    public void crearUsuario(TBUsuarios u){
        usuarioDao.crear(u);
    }
    
    @Override
    public List<TBUsuarios> verUsuarios(){
        return usuarioDao.buscarTodo();
    }
    
    @Override
    public TBUsuarios verUsuario(long id){
       return usuarioDao.buscarPorId(id);
    }
    
    @Override
    public void eliminarUsuarioID(long id){
        usuarioDao.eliminarPorId(id);
    }
    
    @Override
    public void eliminarUsuario(TBUsuarios u){
        usuarioDao.eliminar(u);
    }
    
    @Override
    public TBUsuarios actualizarUsuario(TBUsuarios u) throws Exception{
        if(!validarEditarUsuario(u.getNombreUsuario(),u.getIdUsuario())){
         throw new Exception("Nombre Usuario repetido");
        }
        return usuarioDao.actualizar(u);
    }
    
    @Override
    public TBUsuarios iniciarSesion(TBUsuarios u){
        return usuarioDao.iniciarSesion(u);
    }
    
    public Boolean validarEditarUsuario(String nomUsua, Long idUsu){
        Boolean e ;
        String Valido = usuarioDao.buscarNombreUsuario(nomUsua, idUsu);
        if (StringUtils.isBlank(Valido)) {
            e = true;
        }else{
            e = false;
        }
        
        return e;
    }
}
