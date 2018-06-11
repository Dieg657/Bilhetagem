package DAO.ClassesDB;

import DAO.ClassesDB.Cliente;
import DAO.ClassesDB.Empresa;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-11T03:29:18")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, String> uf;
    public static volatile SingularAttribute<Estado, Integer> idEstado;
    public static volatile SingularAttribute<Estado, String> estado;
    public static volatile CollectionAttribute<Estado, Empresa> empresaCollection;
    public static volatile CollectionAttribute<Estado, Cliente> clienteCollection1;
    public static volatile CollectionAttribute<Estado, Cliente> clienteCollection;

}