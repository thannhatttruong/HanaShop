/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author truongtn
 */
@Entity
@Table(name = "ORDERED", catalog = "HanaShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordered.findAll", query = "SELECT o FROM Ordered o"),
    @NamedQuery(name = "Ordered.findByAmount", query = "SELECT o FROM Ordered o WHERE o.amount = :amount"),
    @NamedQuery(name = "Ordered.findByPrice", query = "SELECT o FROM Ordered o WHERE o.price = :price"),
    @NamedQuery(name = "Ordered.findByTotal", query = "SELECT o FROM Ordered o WHERE o.total = :total"),
    @NamedQuery(name = "Ordered.findByOrderedId", query = "SELECT o FROM Ordered o WHERE o.orderedId = :orderedId")})
public class Ordered implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "amount", nullable = false)
    private int amount;
    @Basic(optional = false)
    @Column(name = "price", nullable = false)
    private int price;
    @Basic(optional = false)
    @Column(name = "total", nullable = false)
    private int total;
    @Id
    @Basic(optional = false)
    @Column(name = "orderedId", nullable = false)
    private Integer orderedId;
    @JoinColumn(name = "bill_Id", referencedColumnName = "bill_Id", nullable = false)
    @ManyToOne(optional = false)
    private Bill billId;
    @JoinColumn(name = "foodId", referencedColumnName = "foodId", nullable = false)
    @ManyToOne(optional = false)
    private Menu foodId;

    public Ordered() {
    }

    public Ordered(Integer orderedId) {
        this.orderedId = orderedId;
    }

    public Ordered(Integer orderedId, int amount, int price, int total) {
        this.orderedId = orderedId;
        this.amount = amount;
        this.price = price;
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Integer getOrderedId() {
        return orderedId;
    }

    public void setOrderedId(Integer orderedId) {
        this.orderedId = orderedId;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }

    public Menu getFoodId() {
        return foodId;
    }

    public void setFoodId(Menu foodId) {
        this.foodId = foodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderedId != null ? orderedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordered)) {
            return false;
        }
        Ordered other = (Ordered) object;
        if ((this.orderedId == null && other.orderedId != null) || (this.orderedId != null && !this.orderedId.equals(other.orderedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "truongtn.entity.Ordered[ orderedId=" + orderedId + " ]";
    }
    
}
