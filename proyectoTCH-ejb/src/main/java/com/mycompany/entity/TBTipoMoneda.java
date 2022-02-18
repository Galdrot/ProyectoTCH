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
@Table(name="TB_TipoMoneda")
public class TBTipoMoneda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name = "id_Moneda")
    private Long idMoneda;
    
    @Column(name = "divisa")
    private String divisa;
    
    @Column(name = "acronimo")
    private String acronimo;

}
