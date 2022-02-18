/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TB_CabeceraPedido")
public class TBCabeceraPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Cabecera")
    private Long idCabecera;
    
    @Column(name = "nombre_Cliente")
    private String nombreCliente;
    
    @Column(name = "identificacion_Cliente")
    private String identificacionCliente;
    
    @Column(name = "fecha_Pedido")
    private Date fechaPedido;
    
    @Column(name = "direccion_Cliente")
    private String direccionCliente;
    
    @Column(name = "correo_Cliente")
    private String correoCliente;
    
    @ManyToOne
    @JoinColumn(name = "id_Moneda")
    private TBTipoMoneda moneda;
    
}
