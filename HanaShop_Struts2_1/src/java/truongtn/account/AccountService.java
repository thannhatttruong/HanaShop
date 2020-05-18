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
public class AccountService implements Serializable {

    private String accountServiceUrl = "http://localhost:8080/HanaShop_JPA_Rest/webresources/account";
    private Gson gson;
    private URI uri;
    private Client client;
    private WebTarget webTarget;
    private Invocation.Builder invocationBuilder;
    private Response res;
    private String result;
    private Form form;

    public AccountService() {
        this.gson = new Gson();
    }

    public AccountDTO checkLogin(String username, String password) {
        String checkLoginUrl = accountServiceUrl + "/checkLogin";
        uri = URI.create(checkLoginUrl);

        client = ClientBuilder.newClient();
        form = new Form();
        form.param("username", username);
        form.param("password", password);

        webTarget = client.target(uri);
        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        res = invocationBuilder.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
        AccountDTO accountDTO = null;
        try {
            result = res.readEntity(String.class);
            accountDTO = gson.fromJson(result, AccountDTO.class);
        } catch (Exception e) {
            System.out.println("Error at AccountService: " + e.getMessage());
        }
        return accountDTO;
    }

    public boolean createAnAccount(AccountDTO accountDTO) {
        String createAnAccountUrl = accountServiceUrl + "/registerAnAccount";
        uri = URI.create(createAnAccountUrl);
        client = ClientBuilder.newClient();
        webTarget = client.target(uri);
        invocationBuilder = webTarget.request();
        res = invocationBuilder.post(Entity.entity(accountDTO, MediaType.APPLICATION_JSON));
        boolean create = false;
        try {
            result = res.readEntity(String.class);
            create = Boolean.parseBoolean(result);
        } catch (Exception e) {
            System.out.println("Error at createAnAccount method in AccountService class: " + e.getMessage());
        }
        return create;
    }
    
//    public static void main(String[] args) {
//        AccountService accountService = new AccountService();
//        AccountDTO accountDTO = new AccountDTO("truong", "trung", "Than Trung", "user");
//        if(accountService.createAnAccount(accountDTO)){
//            System.out.println("Success");
//        }else{
//            System.out.println("Fail");
//        }
//    }
}
