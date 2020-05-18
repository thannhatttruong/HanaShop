/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.entity;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author truongtn
 */
public class AccountBLO implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("HanaShop_JPA_RestPU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Account checkLogin(String username, String password) {
        Account acc = null;
        EntityManager em = emf.createEntityManager();
        String jsql = "Select a.username, a.fullname, a.role, a.accId From Account a Where a.username = ? and a.password = ?";
        Query query = em.createNativeQuery(jsql, Account.class);
        query.setParameter(1, username);
        query.setParameter(2, password);

        try {
            acc = (Account) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error at AccountBLO: " + e.getMessage());
        }
        return acc;
    }

    public boolean createAnAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        String jsql = "Insert into Account(username, password, fullname, role) values (?, ?, ?, ?)";
        Query query = em.createNativeQuery(jsql);
        query.setParameter(1, account.getUsername());
        query.setParameter(2, account.getPassword());
        query.setParameter(3, account.getFullname());
        query.setParameter(4, account.getRole());
        boolean result = false;
        try {
            em.getTransaction().begin();
            result = query.executeUpdate() > 0;
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error at createAnAccount method in AccountBLO class: " + e.getMessage());
        }
        return result;
    }

    public boolean checkExistedUsername(String username) {
        EntityManager em = emf.createEntityManager();
        String jsql = "Select a.accId From Account a Where a.username = ?";
        Query query = em.createNativeQuery(jsql);
        query.setParameter(1, username);
        boolean result = false;
        try {
            if (query.getSingleResult() != null) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error at checkExistedUsername method in AccountBLO class: " + e.getMessage());
            result = false;
        }
        return result;
    }

    public boolean registerAnAccount(Account acc){
        if (!checkExistedUsername(acc.getUsername())) {
            if(createAnAccount(acc)){
                return true;
            }
        }
        return false;
    }
    
//    public static void main(String[] args){
//        AccountBLO blo = new AccountBLO();
//        
//        if(blo.checkExistedUsername("ooo")){
//            System.out.println("Existed");
//        }else{
//            System.out.println("Not existed");
//        }
//       
//    }
}
