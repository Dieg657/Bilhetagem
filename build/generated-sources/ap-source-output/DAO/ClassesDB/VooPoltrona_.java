package DAO.ClassesDB;

import DAO.ClassesDB.Passagem;
import DAO.ClassesDB.Status;
import DAO.ClassesDB.Voo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-11T03:29:18")
@StaticMetamodel(VooPoltrona.class)
public class VooPoltrona_ { 

    public static volatile SingularAttribute<VooPoltrona, Integer> idtbVooPoltrona;
    public static volatile SingularAttribute<VooPoltrona, Integer> poltrona;
    public static volatile SingularAttribute<VooPoltrona, Passagem> localizador;
    public static volatile SingularAttribute<VooPoltrona, Status> status;
    public static volatile SingularAttribute<VooPoltrona, Voo> vooTag;

}