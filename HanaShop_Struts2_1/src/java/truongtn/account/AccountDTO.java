/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.account;

//import truongtn.bill.BillDTO;

import java.io.Serializable;


/**
 *
 * @author truongtn
 */
public class AccountDTO implements Serializable{

    private String username;
    private String password;
    private String fullname;
    private String gmail;
    private String paypalID;
    private String role;
    private Long accId;
    private String facebookID;
//    private Collection<BillDTO> billCollection;

    public AccountDTO() {
    }

    public AccountDTO(Long accId) {
        this.accId = accId;
    }

    public AccountDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AccountDTO(String username, String password, String fullname, String role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
    }

    
    public AccountDTO(String username, String fullname, String role, Long accId) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
        this.accId = accId;
    }

    public AccountDTO(Long accId, String fullname, String role) {
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

    public Long getAccId() {
        return accId;
    }

    public void setAccId(Long accId) {
        this.accId = accId;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

}
