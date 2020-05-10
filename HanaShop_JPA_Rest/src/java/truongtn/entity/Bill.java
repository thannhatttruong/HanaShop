/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author truongtn
 */
@Entity
@Table(name = "BILL", catalog = "HanaShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findByBillId", query = "SELECT b FROM Bill b WHERE b.billId = :billId"),
    @NamedQuery(name = "Bill.findByTotalOfBill", query = "SELECT b FROM Bill b WHERE b.totalOfBill = :totalOfBill"),
    @NamedQuery(name = "Bill.findByPayTime", query = "SELECT b FROM Bill b WHERE b.payTime = :payTime"),
    @NamedQuery(name = "Bill.findByTypeOfPay", query = "SELECT b FROM Bill b WHERE b.typeOfPay = :typeOfPay")})
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "bill_Id", nullable = false)
    private Integer billId;
    @Basic(optional = false)
    @Column(name = "totalOfBill", nullable = false)
    private int totalOfBill;
    @Basic(optional = false)
    @Column(name = "payTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date payTime;
    @Basic(optional = false)
    @Column(name = "typeOfPay", nullable = false, length = 30)
    private String typeOfPay;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billId")
    private Collection<Ordered> orderedCollection;
    @JoinColumn(name = "userId", referencedColumnName = "accId", nullable = false)
    @ManyToOne(optional = false)
    private Account userId;

    public Bill() {
    }

    public Bill(Integer billId) {
        this.billId = billId;
    }

    public Bill(Integer billId, int totalOfBill, Date payTime, String typeOfPay) {
        this.billId = billId;
        this.totalOfBill = totalOfBill;
        this.payTime = payTime;
        this.typeOfPay = typeOfPay;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public int getTotalOfBill() {
        return totalOfBill;
    }

    public void setTotalOfBill(int totalOfBill) {
        this.totalOfBill = totalOfBill;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getTypeOfPay() {
        return typeOfPay;
    }

    public void setTypeOfPay(String typeOfPay) {
        this.typeOfPay = typeOfPay;
    }

    @XmlTransient
    public Collection<Ordered> getOrderedCollection() {
        return orderedCollection;
    }

    public void setOrderedCollection(Collection<Ordered> orderedCollection) {
        this.orderedCollection = orderedCollection;
    }

    public Account getUserId() {
        return userId;
    }

    public void setUserId(Account userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billId != null ? billId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.billId == null && other.billId != null) || (this.billId != null && !this.billId.equals(other.billId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "truongtn.entity.Bill[ billId=" + billId + " ]";
    }
    
}
