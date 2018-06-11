package DAO.ClassesDB;

import DAO.ClassesDB.Estado;
import DAO.ClassesDB.Passagem;
import DAO.ClassesDB.UsuarioCliente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-11T03:29:18")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> nmCli;
    public static volatile SingularAttribute<Cliente, String> numCli;
    public static volatile SingularAttribute<Cliente, String> obsCli;
    public static volatile SingularAttribute<Cliente, String> docCli;
    public static volatile SingularAttribute<Cliente, String> complCli;
    public static volatile SingularAttribute<Cliente, Estado> idufCli;
    public static volatile SingularAttribute<Cliente, String> cidadeCli;
    public static volatile SingularAttribute<Cliente, Long> cpfCli;
    public static volatile SingularAttribute<Cliente, String> bairroCli;
    public static volatile SingularAttribute<Cliente, UsuarioCliente> usuarioCliente;
    public static volatile SingularAttribute<Cliente, String> endCli;
    public static volatile SingularAttribute<Cliente, Date> dtnascCli;
    public static volatile SingularAttribute<Cliente, String> emailCli;
    public static volatile CollectionAttribute<Cliente, Passagem> passagemCollection;
    public static volatile SingularAttribute<Cliente, Estado> idestCli;
    public static volatile SingularAttribute<Cliente, String> orgCli;

}