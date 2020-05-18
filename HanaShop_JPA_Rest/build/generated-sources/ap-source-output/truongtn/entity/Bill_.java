package truongtn.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import truongtn.entity.Account;
import truongtn.entity.Ordered;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-15T14:44:00")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, Date> payTime;
    public static volatile CollectionAttribute<Bill, Ordered> orderedCollection;
    public static volatile SingularAttribute<Bill, Integer> billId;
    public static volatile SingularAttribute<Bill, Integer> totalOfBill;
    public static volatile SingularAttribute<Bill, String> typeOfPay;
    public static volatile SingularAttribute<Bill, Account> userId;

}