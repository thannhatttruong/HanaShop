/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.action;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import truongtn.account.AccountDTO;
import truongtn.account.AccountService;


/**
 *
 * @author truongtn
 */
@ResultPath("/")
@Results({
    @Result(name = "guest", type = "redirectAction", params = {"actionName", "search", "searchValue", "${lastSearchValue}"}),
    @Result(name = "admin", type = "redirectAction", params = {"actionName", "find", "searchValue", "${lastSearchValue}"}),
    @Result(name = "fail", type = "redirect", location = "invalid.html")
})
public class LoginAction {
    private String username;
    private String password;
    private String lastSearchValue;
    private final String GUEST = "guest";
    private final String ADMIN = "admin";
    private final String FAIL = "fail";
    
    public LoginAction() {
        
    }
    
    public String execute() throws Exception {
        AccountService accountService = new AccountService();
        AccountDTO acc = accountService.checkLogin(username, password);
        String url = FAIL;
        if(acc != null){
            Map session = ActionContext.getContext().getSession();
            session.put("USER", acc);
            url = GUEST;
            if(acc.getRole().equals("admin")){
                url = ADMIN;
            }
        }
        return url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the lastSearchValue
     */
    public String getLastSearchValue() {
        return lastSearchValue;
    }

    /**
     * @param lastSearchValue the lastSearchValue to set
     */
    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

   
}
