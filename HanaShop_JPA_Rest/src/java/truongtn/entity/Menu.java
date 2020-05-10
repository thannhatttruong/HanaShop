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
import javax.persistence.Lob;
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
@Table(name = "MENU", catalog = "HanaShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByFoodId", query = "SELECT m FROM Menu m WHERE m.foodId = :foodId"),
    @NamedQuery(name = "Menu.findByName", query = "SELECT m FROM Menu m WHERE m.name = :name"),
    @NamedQuery(name = "Menu.findByPrice", query = "SELECT m FROM Menu m WHERE m.price = :price"),
    @NamedQuery(name = "Menu.findByCategory", query = "SELECT m FROM Menu m WHERE m.category = :category"),
    @NamedQuery(name = "Menu.findByQuantity", query = "SELECT m FROM Menu m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "Menu.findByUpdateDate", query = "SELECT m FROM Menu m WHERE m.updateDate = :updateDate"),
    @NamedQuery(name = "Menu.findByStatus", query = "SELECT m FROM Menu m WHERE m.status = :status")})

public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "foodId", nullable = false)
    private Integer foodId;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @Column(name = "price", nullable = false)
    private int price;
    @Basic(optional = false)
    @Column(name = "category", nullable = false, length = 30)
    private String category;
    @Basic(optional = false)
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(name = "updateDate", nullable = false)
    private String updateDate;
    @Basic(optional = false)
    @Column(name = "status", nullable = false, length = 10)
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodId")
    private Collection<Ordered> orderedCollection;

    public Menu() {
    }

    public Menu(Integer foodId) {
        this.foodId = foodId;
    }

    public Menu(Integer foodId, String name, byte[] image, int price, String category, int quantity, String updateDate, String status) {
        this.foodId = foodId;
        this.name = name;
        this.image = image;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.updateDate = updateDate;
        this.status = status;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @XmlTransient
    public Collection<Ordered> getOrderedCollection() {
        return orderedCollection;
    }

    public void setOrderedCollection(Collection<Ordered> orderedCollection) {
        this.orderedCollection = orderedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodId != null ? foodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.foodId == null && other.foodId != null) || (this.foodId != null && !this.foodId.equals(other.foodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "truongtn.entity.Menu[ foodId=" + foodId + " ]";
    }
    
}
