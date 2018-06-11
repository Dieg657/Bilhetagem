package DAO.ClassesDB;

import DAO.ClassesDB.Funcionario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-11T03:29:18")
@StaticMetamodel(UsuarioFuncionario.class)
public class UsuarioFuncionario_ { 

    public static volatile SingularAttribute<UsuarioFuncionario, String> senha;
    public static volatile SingularAttribute<UsuarioFuncionario, String> usuario;
    public static volatile SingularAttribute<UsuarioFuncionario, Long> cpfFunc;
    public static volatile SingularAttribute<UsuarioFuncionario, Funcionario> funcionario;

}