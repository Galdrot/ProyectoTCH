/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicios.interfaz;

import com.mycompany.entity.TBUsuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dhern
 */

@Local
public interface IUsuariosServicio {
    
    void crearUsuario(TBUsuarios u);
    
    List<TBUsuarios> verUsuarios();
    
    TBUsuarios verUsuario(long id);
    
    void eliminarUsuarioID(long id);
   
    void eliminarUsuario(TBUsuarios u);
    
    TBUsuarios actualizarUsuario(TBUsuarios u) throws Exception;
    
    TBUsuarios iniciarSesion(TBUsuarios u);
}
