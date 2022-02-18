/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dhern
 */
@Entity
@Getter
@Setter
@Table(name="TB_Pedido")
public class TBPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Pedido")
    private Long idPedido;

    @Column(name="codigo_Producto")
    private String codigoProducto ;
    
    @Column(name="nombre_Producto")
    private String nombreProducto;
    
    @Column(name="unidad_Producto")
    private String unidadProducto ;
    
    @Column(name="cantidad_Producto")
    private String cantidadProducto;
    
    @Column(name="valor_Producto")
    private Long valorProducto ;
    
    @Column(name="id_Cabecera")
    private Long idCabecera;
}
