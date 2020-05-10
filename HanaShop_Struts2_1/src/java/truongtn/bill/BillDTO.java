/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.bill;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import truongtn.account.AccountDTO;

/**
 *
 * @author truongtn
 */
@XmlRootElement
public class BillDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer billId;
    private int totalOfBill;
    private Date payTime;
    private String typeOfPay;
//    private Collection<Ordered> orderedCollection;
    private AccountDTO userId;

    public BillDTO() {
    }

    public BillDTO(Integer billId) {
        this.billId = billId;
    }

    public BillDTO(Integer billId, int totalOfBill, Date payTime, String typeOfPay) {
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

//    @XmlTransient
//    public Collection<Ordered> getOrderedCollection() {
//        return orderedCollection;
//    }
//
//    public void setOrderedCollection(Collection<Ordered> orderedCollection) {
//        this.orderedCollection = orderedCollection;
//    }

    public AccountDTO getUserId() {
        return userId;
    }

    public void setUserId(AccountDTO userId) {
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
        if (!(object instanceof BillDTO)) {
            return false;
        }
        BillDTO other = (BillDTO) object;
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
