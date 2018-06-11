package DAO.ClassesDB;

import DAO.ClassesDB.Estado;
import DAO.ClassesDB.Funcionario;
import DAO.ClassesDB.Voo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-11T03:29:18")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> numEmpresa;
    public static volatile CollectionAttribute<Empresa, Voo> vooCollection;
    public static volatile SingularAttribute<Empresa, Integer> cepEmp;
    public static volatile SingularAttribute<Empresa, String> inestEmp;
    public static volatile SingularAttribute<Empresa, Long> cnpj;
    public static volatile SingularAttribute<Empresa, String> fantasiaEmp;
    public static volatile SingularAttribute<Empresa, String> obsEmp;
    public static volatile SingularAttribute<Empresa, String> complEmp;
    public static volatile SingularAttribute<Empresa, String> emailEmp;
    public static volatile SingularAttribute<Empresa, String> cidadeEmp;
    public static volatile SingularAttribute<Empresa, Estado> idestEmp;
    public static volatile CollectionAttribute<Empresa, Funcionario> funcionarioCollection;
    public static volatile SingularAttribute<Empresa, String> endEmp;

}