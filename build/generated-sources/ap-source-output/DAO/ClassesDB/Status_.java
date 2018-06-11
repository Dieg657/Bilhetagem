package DAO.ClassesDB;

import DAO.ClassesDB.VooPoltrona;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-11T03:29:18")
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile SingularAttribute<Status, Integer> idStatus;
    public static volatile CollectionAttribute<Status, VooPoltrona> vooPoltronaCollection;
    public static volatile SingularAttribute<Status, String> status;

}