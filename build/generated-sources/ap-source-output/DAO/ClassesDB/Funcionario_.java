package DAO.ClassesDB;

import DAO.ClassesDB.Empresa;
import DAO.ClassesDB.UsuarioFuncionario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-11T03:29:18")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, Integer> telFunc;
    public static volatile SingularAttribute<Funcionario, String> obsFunc;
    public static volatile SingularAttribute<Funcionario, Integer> idsexoFunc;
    public static volatile SingularAttribute<Funcionario, String> nmFunc;
    public static volatile SingularAttribute<Funcionario, UsuarioFuncionario> usuarioFuncionario;
    public static volatile SingularAttribute<Funcionario, Empresa> cnpjEmp;
    public static volatile SingularAttribute<Funcionario, Long> cpfFunc;
    public static volatile SingularAttribute<Funcionario, String> emailFunc;

}