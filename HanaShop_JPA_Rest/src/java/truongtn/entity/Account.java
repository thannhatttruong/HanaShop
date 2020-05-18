/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author truongtn
 */
@Entity
@Table(name = "ACCOUNT", catalog = "HanaShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
    @NamedQuery(name = "Account.findByFullname", query = "SELECT a FROM Account a WHERE a.fullname = :fullname"),
    @NamedQuery(name = "Account.findByGmail", query = "SELECT a FROM Account a WHERE a.gmail = :gmail"),
    @NamedQuery(name = "Account.findByPaypalID", query = "SELECT a FROM Account a WHERE a.paypalID = :paypalID"),
    @NamedQuery(name = "Account.findByRole", query = "SELECT a FROM Account a WHERE a.role = :role"),
    @NamedQuery(name = "Account.findByAccId", query = "SELECT a FROM Account a WHERE a.accId = :accId"),
    @NamedQuery(name = "Account.findByFacebookID", query = "SELECT a FROM Account a WHERE a.facebookID = :facebookID")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "username", length = 50)
    private String username;
    @Column(name = "password", length = 30)
    private String password;
    @Basic(optional = false)
    @Column(name = "fullname", nullable = false, length = 50)
    private String fullname;
    @Column(name = "gmail", length = 50)
    private String gmail;
    @Column(name = "paypalID", length = 20)
    private String paypalID;
    @Basic(optional = false)
    @Column(name = "role", nullable = false, length = 30)
    private String role;
    @Id
    @Basic(optional = false)
    @Column(name = "accId", nullable = false)
    private Integer accId;
    @Column(name = "facebookID", length = 30)
    private String facebookID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Bill> billCollection;

    public Account() {
    }

    public Account(Integer accId) {
        this.accId = accId;
    }

    public Account(String username, String fullname, String role) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
    }

    public Account(String username, String password, String fullname, String role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
    }
    
    public Account(Integer accId, String fullname, String role) {
        this.accId = accId;
        this.fullname = fullname;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPaypalID() {
        return paypalID;
    }

    public void setPaypalID(String paypalID) {
        this.paypalID = paypalID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    @XmlTransient
    public Collection<Bill> getBillCollection() {
        return billCollection;
    }

    public void setBillCollection(Collection<Bill> billCollection) {
        this.billCollection = billCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accId != null ? accId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accId == null && other.accId != null) || (this.accId != null && !this.accId.equals(other.accId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "truongtn.entity.Account[ accId=" + accId + " ]";
    }
    
}
