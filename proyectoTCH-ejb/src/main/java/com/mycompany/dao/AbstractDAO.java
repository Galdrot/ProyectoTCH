/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dhern
 * @param <T>
 */
public class AbstractDAO< T extends Serializable> {

    private Class<T> claseGenerica;

    @PersistenceContext(unitName = "persistencia")
    EntityManager e;

    public final void setClaseGenerica(Class<T> claseGenerica) {
        this.claseGenerica = claseGenerica;
    }

    public T buscarPorId(long id) {
        return e.find(claseGenerica, id);
    }

    public List<T> buscarTodo() {
        return e.createQuery("select c from " + claseGenerica.getName() + " c").getResultList();
    }

    public void crear(T entidad) {
        e.persist(entidad);
        e.flush();
    }

    public T actualizar(T entidad) {
        return e.merge(entidad);
    }

    public void eliminar(T entidad) {
        if (!e.contains(entidad)) {
            entidad = e.merge(entidad);
        }
        e.remove(entidad);
    }

    public void eliminarPorId(long id) {
        T entity = buscarPorId(id);
        eliminar(entity);
    }

}
