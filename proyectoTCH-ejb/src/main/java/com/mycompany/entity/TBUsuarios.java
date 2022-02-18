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
@Table (name = "TB_Usuarios")
@Getter
@Setter
public class TBUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id_Usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @Column(name="nombre_Completo")
    private String nombreCompleto;
    
    @Column(name="nombre_Usuario")
    private String nombreUsuario;
    
    @Column(name="contraseba")
    private String contrasena;    
}
