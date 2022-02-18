package com.mycompany.entity;

import com.mycompany.entity.TBTipoMoneda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-18T09:06:52")
@StaticMetamodel(TBCabeceraPedido.class)
public class TBCabeceraPedido_ { 

    public static volatile SingularAttribute<TBCabeceraPedido, String> correoCliente;
    public static volatile SingularAttribute<TBCabeceraPedido, String> identificacionCliente;
    public static volatile SingularAttribute<TBCabeceraPedido, Long> idCabecera;
    public static volatile SingularAttribute<TBCabeceraPedido, String> nombreCliente;
    public static volatile SingularAttribute<TBCabeceraPedido, String> direccionCliente;
    public static volatile SingularAttribute<TBCabeceraPedido, TBTipoMoneda> moneda;
    public static volatile SingularAttribute<TBCabeceraPedido, Date> fechaPedido;

}