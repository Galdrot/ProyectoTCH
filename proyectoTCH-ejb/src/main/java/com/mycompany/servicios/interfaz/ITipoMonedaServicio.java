/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicios.interfaz;

import com.mycompany.entity.TBTipoMoneda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dhern
 */

@Local
public interface ITipoMonedaServicio {
    
    List<TBTipoMoneda> verTiposMonedas();
   
    TBTipoMoneda verTipoMoneda(long id);
}
