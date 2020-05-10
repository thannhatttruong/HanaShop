package truongtn.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import truongtn.entity.Bill;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-06T17:26:38")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> gmail;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> role;
    public static volatile SingularAttribute<Account, String> facebookID;
    public static volatile SingularAttribute<Account, Integer> accId;
    public static volatile SingularAttribute<Account, String> fullname;
    public static volatile SingularAttribute<Account, String> paypalID;
    public static volatile CollectionAttribute<Account, Bill> billCollection;
    public static volatile SingularAttribute<Account, String> username;

}