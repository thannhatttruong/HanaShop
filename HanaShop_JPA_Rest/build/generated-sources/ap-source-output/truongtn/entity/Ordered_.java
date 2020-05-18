package truongtn.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import truongtn.entity.Bill;
import truongtn.entity.Menu;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-15T14:44:00")
@StaticMetamodel(Ordered.class)
public class Ordered_ { 

    public static volatile SingularAttribute<Ordered, Integer> amount;
    public static volatile SingularAttribute<Ordered, Integer> total;
    public static volatile SingularAttribute<Ordered, Integer> price;
    public static volatile SingularAttribute<Ordered, Bill> billId;
    public static volatile SingularAttribute<Ordered, Menu> foodId;
    public static volatile SingularAttribute<Ordered, Integer> orderedId;

}