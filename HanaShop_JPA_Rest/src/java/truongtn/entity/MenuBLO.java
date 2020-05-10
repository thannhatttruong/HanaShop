/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.entity;

import java.io.Serializable;
import java.util.List;
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
public class MenuBLO implements Serializable{
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
   
    
    public List loadInitPage(){
        EntityManager em = emf.createEntityManager();
        String jsql = "Select m From Menu m Where m.status = 'active' and m.quantity > 0";
        Query query = em.createQuery(jsql);
        List list = null;
        try {
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error at loadInitPage method in MenuBLO class: " + e.getMessage());
        }
        return list;
    }
    
    public List loadAdminPage(){
        EntityManager em = emf.createEntityManager();
        String jsql = "Menu.findAll";
        Query query = em.createNamedQuery(jsql);
        List list = null;
        try {
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error at loadAdminPage method in MenuBLO class: " + e.getMessage());
        }
        return list;
    }
    
    public List searchLikeFoodName(String searchValue){
        EntityManager em = emf.createEntityManager();
        String jsql = "Select m From Menu m Where m.status = 'active' and m.quantity > 0 and m.name Like :name";
        Query query = em.createQuery(jsql);
        query.setParameter("name", "%" + searchValue + "%");
        List list = null;
        try {
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error at searchLikeFoodName method in MenuBLO class: " + e.getMessage());
        }
        return list;
    }
    
    public List findLikeFoodName(String searchValue){
        EntityManager em = emf.createEntityManager();
        String jsql = "Select m From Menu m Where m.name Like :name";
        Query query = em.createQuery(jsql);
        query.setParameter("name", "%" + searchValue + "%");
        List list = null;
        try {
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error at findLikeFoodName method in MenuBLO class: " + e.getMessage());
        }
        return list;
    }
    
    public boolean removeItem(String pk){
        EntityManager em = emf.createEntityManager();
        String jsql = "Update Menu set status = 'inactive' Where foodId = :foodId";
        em.getTransaction().begin();
        Query query = em.createQuery(jsql);
        try {
            int foodId = Integer.parseInt(pk.trim());
            query.setParameter("foodId", foodId);
            
            boolean result = query.executeUpdate() > 0;
          
            em.getTransaction().commit();
            if (result) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error at removeItem method in MenuBLO class: " + e.getMessage());
        }
        return false;
    }
    
    public Menu getAnItem(String pk){
        EntityManager em = emf.createEntityManager();
        String jsql = "Menu.findByFoodId";
        Query query = em.createNamedQuery(jsql);
        Menu menu = null;
        try {
            int foodId = Integer.parseInt(pk);
            query.setParameter("foodId", foodId);
            menu = (Menu) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error at getItemByID method in MenuBLO class: " + e.getMessage());
        }
        
        return menu;
    }
    
    public List getAllCategory(){
        EntityManager em = emf.createEntityManager();
        String jsql = "Select distinct m.category From Menu m";
        Query query = em.createQuery(jsql);
        List result = null;
        try {
            result = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error at getAllCategory method in MenuBLO class: " + e.getMessage());
        }
        return result;
    }
    public static void main(String[] args){
        MenuBLO blo = new MenuBLO();
        List<String> list = blo.getAllCategory();
        for (String list1 : list) {
            System.out.println("Category name: " + list1);
        }
        
    }
}
