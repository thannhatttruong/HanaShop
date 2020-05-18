/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.restFul;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import truongtn.entity.Account;
import truongtn.entity.AccountBLO;

/**
 * REST Web Service
 *
 * @author truongtn
 */
@Path("account")
public class AccountResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AccountResource
     */
    public AccountResource() {
    }

    @Path("/checkLogin")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Account checkLogin(@FormParam("username") String username,
            @FormParam("password") String password) {
        AccountBLO blo = new AccountBLO();
        Account acc = blo.checkLogin(username, password);
        return acc;
    }

    @Path("/registerAnAccount")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String createAnAccount(Account account){
        AccountBLO blo = new AccountBLO();
        boolean result = blo.registerAnAccount(account);
        
        if(result){
            return "true";
        }
        return "false"; 
    }
}
