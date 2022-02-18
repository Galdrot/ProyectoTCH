/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.interfaz;

import com.mycompany.entity.TBUsuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dhern
 */

@Local
public interface IUsuariosDAO  {
    
     void crear(TBUsuarios entidad);
     
     List<TBUsuarios> buscarTodo();
     
     void eliminarPorId(long entidadID);
     
     void eliminar(TBUsuarios entidad);
     
     TBUsuarios buscarPorId(long id);
     
     TBUsuarios actualizar(TBUsuarios entidad);
     
     String buscarNombreUsuario(String nomUsuario, Long idUs);
     
     TBUsuarios iniciarSesion(TBUsuarios u);
}
