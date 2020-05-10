/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.account;

import com.google.gson.Gson;
import java.io.Serializable;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author truongtn
 */
public class AccountService implements Serializable{
    private String accountServiceUrl = "http://localhost:8080/HanaShop_JPA_Rest/webresources/account";
    private Gson gson;
    public AccountService() {
        this.gson = new Gson();
    }

    public AccountDTO checkLogin(String username, String password){
        String checkLoginUrl = accountServiceUrl + "/checkLogin";
        URI uri = URI.create(checkLoginUrl);
        
        Client client = ClientBuilder.newClient();
        Form form = new Form();
        form.param("username", username);
        form.param("password", password);
        
        WebTarget webTarget = client.target(uri);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response res = invocationBuilder.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
        AccountDTO accountDTO = null;
        try {
            String result =  res.readEntity(String.class);
            accountDTO = gson.fromJson(result, AccountDTO.class);
        } catch (Exception e) {
            System.out.println("Error at AccountService: " + e.getMessage());
        }
        return accountDTO;
    }
}
