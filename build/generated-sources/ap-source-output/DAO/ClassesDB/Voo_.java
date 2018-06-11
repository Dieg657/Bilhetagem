package DAO.ClassesDB;

import DAO.ClassesDB.Empresa;
import DAO.ClassesDB.VooPoltrona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-11T03:29:18")
@StaticMetamodel(Voo.class)
public class Voo_ { 

    public static volatile SingularAttribute<Voo, Date> hrPartida;
    public static volatile SingularAttribute<Voo, Long> vlVoo;
    public static volatile CollectionAttribute<Voo, VooPoltrona> vooPoltronaCollection;
    public static volatile SingularAttribute<Voo, String> origem;
    public static volatile SingularAttribute<Voo, Empresa> cpnjEmp;
    public static volatile SingularAttribute<Voo, Date> dtPartida;
    public static volatile SingularAttribute<Voo, String> destino;
    public static volatile SingularAttribute<Voo, String> vooTag;

}