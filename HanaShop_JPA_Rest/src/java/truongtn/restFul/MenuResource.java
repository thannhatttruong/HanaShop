/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.restFul;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import truongtn.entity.Menu;
import truongtn.entity.MenuBLO;

/**
 * REST Web Service
 *
 * @author truongtn
 */
@Path("menu")
public class MenuResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MenuResource
     */
    public MenuResource() {
    }

    @Path("/loadInitPage")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Menu> loadInitPage(){
        MenuBLO blo = new MenuBLO();
        List<Menu> result = blo.loadInitPage();
        return result;
    }
    
    @Path("/loadAdminPage")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Menu> loadAdminPage(){
        MenuBLO blo = new MenuBLO();
        List<Menu> result = blo.loadAdminPage();
        return result;
    }
    
    @Path("/searchByName")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Menu> searchByFoodName(@QueryParam("searchValue") String searchValue){
        MenuBLO blo = new MenuBLO();
        List<Menu> result = blo.searchLikeFoodName(searchValue);
        
        return result;
    }
    
    @Path("/findByName")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Menu> findByFoodName(@QueryParam("searchValue") String searchValue){
        MenuBLO blo = new MenuBLO();
        List<Menu> result = blo.findLikeFoodName(searchValue);
        
        return result;
    }
    
    @Path("/removeItem")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String removeItem(@QueryParam("pk") String pk){
        MenuBLO blo = new MenuBLO();
        if(blo.removeItem(pk)){
            return "true";
        }
        return "false";
    }
    
    @Path("/getAnItem")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Menu getAnItem(@QueryParam("pk") String pk){
        MenuBLO blo = new MenuBLO();
        Menu menu = blo.getAnItem(pk);
        return menu;
    }
    
    @Path("/getAllCategory")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCategory(){
        MenuBLO blo = new MenuBLO();
        List<String> result = blo.getAllCategory();
        
        return new Gson().toJson(result);
    }
    
    
    @Path("/updateAnItem")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateAnItem(Menu menu){
        MenuBLO blo = new MenuBLO();
        if(blo.updateAnItem(menu)){
            return "true";
        }
        return "false";
    }
    
}
