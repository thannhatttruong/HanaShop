/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.menu;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author truongtn
 */
public class MenuService {
    private String menuServiceUrl = "http://localhost:8080/HanaShop_JPA_Rest/webresources/menu";
    private Gson gson;
    private URI uri;
    private Client client;
    private WebTarget webTarget;
    private Invocation.Builder invocationBuilder;
    private Response res;
    private String result;
    
    private List<MenuDTO> itemList;
    private Type menuListType;
    private Type stringListType;
    
    public MenuService() {
        this.gson = new Gson();
        this.menuListType = new TypeToken<ArrayList<MenuDTO>>(){}.getType();
        this.stringListType = new TypeToken<ArrayList<String>>(){}.getType();
    }

    public void loadHomePage(){
        String loadHomePageUrl = menuServiceUrl + "/loadInitPage";
        uri = URI.create(loadHomePageUrl);
        client = ClientBuilder.newClient();
        webTarget = client.target(uri);
        invocationBuilder = webTarget.request();
        res = invocationBuilder.get();
        
        try {
            result = res.readEntity(String.class);
            if(!result.trim().isEmpty()){
                itemList = new ArrayList<>();
                itemList = gson.fromJson(result, menuListType);
            }
        } catch (Exception e) {
            System.out.println("Error at loadHomePage method in MenuService class: " + e.getMessage());
        }
        
    }
    
    public void loadAdminPage(){
        String loadHomePageUrl = menuServiceUrl + "/loadAdminPage";
        uri = URI.create(loadHomePageUrl);
        client = ClientBuilder.newClient();
        webTarget = client.target(uri);
        invocationBuilder = webTarget.request();
        res = invocationBuilder.get();
        
        try {
            result = res.readEntity(String.class);
            if(!result.trim().isEmpty()){
                itemList = new ArrayList<>();
                itemList = gson.fromJson(result, menuListType);
            }
        } catch (Exception e) {
            System.out.println("Error at loadHomePage method in MenuService class: " + e.getMessage());
        }
    }
    public void searchLikeFoodName(String searchValue){
        String searchLikeNameUrl = menuServiceUrl + "/searchByName?searchValue=" + searchValue; 
        uri = URI.create(searchLikeNameUrl);
        client = ClientBuilder.newClient();
        webTarget = client.target(uri);
        invocationBuilder = webTarget.request();
        res = invocationBuilder.get();
        
        try {
            result = res.readEntity(String.class);
            System.out.println("Resutl: " +result);
            if(!result.trim().isEmpty()){
                itemList = new ArrayList<>();
                itemList = gson.fromJson(result, menuListType);
            }
        } catch (Exception e) {
            System.out.println("Error at searchLikeFoodName method at MenuService class: " + e.getMessage());
        }
    }
    
    public void findLikeFoodName(String searchValue){
        String searchLikeNameUrl = menuServiceUrl + "/findByName?searchValue=" + searchValue; 
        uri = URI.create(searchLikeNameUrl);
        client = ClientBuilder.newClient();
        webTarget = client.target(uri);
        invocationBuilder = webTarget.request();
        res = invocationBuilder.get();
        
        try {
            result = res.readEntity(String.class);
            if(!result.trim().isEmpty()){
                itemList = new ArrayList<>();
                itemList = gson.fromJson(result, menuListType);
            }
        } catch (Exception e) {
            System.out.println("Error at findLikeFoodName method at MenuService class: " + e.getMessage());
        }
    }
    
    public void searchByMoneyRange(){
        
    }
    
    public void searchByCategory(){
        
    }
    
    public List<MenuDTO> getItemList() {
        return itemList;
    }
   
    public boolean removeItem(String pk){
        String removeItemUrl = menuServiceUrl + "/removeItem?pk=" + pk;
        uri = URI.create(removeItemUrl);
        client = ClientBuilder.newClient();
        webTarget = client.target(uri);
        invocationBuilder = webTarget.request();
        res = invocationBuilder.get();
        
        try {
            result = res.readEntity(String.class);
            boolean removed = Boolean.parseBoolean(result);
            if(removed){
                return  true;
            }
        } catch (Exception e) {
            System.out.println("Error at removeItem method in MenuService class: " + e.getMessage());
        }
        return false;
    }
    
    public MenuDTO getItemByID(String pk){
        String itemUrl = menuServiceUrl + "/getAnItem?pk=" + pk;
        MenuDTO item = null;
        uri = URI.create(itemUrl);
        client = ClientBuilder.newClient();
        webTarget = client.target(uri);
        invocationBuilder = webTarget.request();
        res = invocationBuilder.get();
        try {
           result = res.readEntity(String.class);
           if(!result.trim().isEmpty()){
               item = gson.fromJson(result, MenuDTO.class);
           }
        } catch (Exception e) {
            System.out.println("Error at getAnItem method in MenuService class: " + e.getMessage());
        }
        return item;
    }
    
    public List<String> getAllCategory(){
        String categoryUrl = menuServiceUrl + "/getAllCategory";
        
        List<String> categoryList = null;
        uri = URI.create(categoryUrl);
        client = ClientBuilder.newClient();
        webTarget = client.target(uri);
        invocationBuilder = webTarget.request();
        res = invocationBuilder.get();
        try {
            result = res.readEntity(String.class);
            if(!result.trim().isEmpty()){
                categoryList = gson.fromJson(result, stringListType);
            }
        } catch (Exception e) {
            System.out.println("Error at getAllCategory method in MeneService class: " + e.getMessage());
        }
        return categoryList;
    } 
    
    public boolean updateAnItem(MenuDTO menu){
        String updateUrl = menuServiceUrl + "/updateAnItem";
        uri = URI.create(updateUrl);
        client = ClientBuilder.newClient();
        webTarget = client.target(uri);
        invocationBuilder = webTarget.request();
        res = invocationBuilder.put(Entity.entity(menu, MediaType.APPLICATION_JSON));
        boolean update = false;
        try {
            result = res.readEntity(String.class);
            update = Boolean.parseBoolean(result);
            
        } catch (Exception e) {
            System.out.println("Error at updateAnItem method in MenuService class: " + e.getMessage());
        }
        return update;
    }
    
//    public static void main(String[] args) {
//        MenuService menuService = new MenuService();
//        MenuDTO menu = new MenuDTO("3", "Noodle", null, Long.getLong("25000"), "food", 3, "inactive");
//        if(menuService.updateAnItem(menu)){
//            System.out.println("Successfully");
//        }else{
//            System.out.println("Fail sml");
//        }
//    }
}
