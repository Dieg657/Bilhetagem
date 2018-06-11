package DAO.ClassesDB;

import DAO.ClassesDB.Cliente;
import DAO.ClassesDB.VooPoltrona;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-11T03:29:18")
@StaticMetamodel(Passagem.class)
public class Passagem_ { 

    public static volatile CollectionAttribute<Passagem, VooPoltrona> vooPoltronaCollection;
    public static volatile SingularAttribute<Passagem, Integer> passBagagem;
    public static volatile SingularAttribute<Passagem, String> passLocalizador;
    public static volatile SingularAttribute<Passagem, Cliente> cpfPassageiro;

}