package truongtn.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import truongtn.entity.Ordered;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-06T17:26:38")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, byte[]> image;
    public static volatile SingularAttribute<Menu, Date> updateDate;
    public static volatile SingularAttribute<Menu, Integer> quantity;
    public static volatile CollectionAttribute<Menu, Ordered> orderedCollection;
    public static volatile SingularAttribute<Menu, Integer> price;
    public static volatile SingularAttribute<Menu, Integer> foodId;
    public static volatile SingularAttribute<Menu, String> name;
    public static volatile SingularAttribute<Menu, String> category;
    public static volatile SingularAttribute<Menu, String> status;

}