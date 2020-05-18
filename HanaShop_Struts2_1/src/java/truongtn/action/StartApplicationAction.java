/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import truongtn.account.AccountDTO;
import truongtn.account.AccountService;

/**
 *
 * @author truongtn
 */
@Path("/")
@Action(value = "", results = {
    @Result(name = "success", type = "redirectAction", params = {"actionName", "find", "searchValue", ""}),
    @Result(name = "fail", type = "redirectAction", params = {"actionName", "search", "searchValue", ""})
})
public class StartApplicationAction extends ActionSupport implements ServletResponseAware, ServletRequestAware{
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    protected HttpServletRequest servletRequest;
    protected HttpServletResponse servletResponse;
    public StartApplicationAction() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        Cookie[] cookies = servletRequest.getCookies();
        if(cookies != null){
            Cookie currentCookie = cookies[cookies.length - 1];
            String username = currentCookie.getName();
            String password = currentCookie.getValue();
            
            AccountService accountService = new AccountService();
            AccountDTO acc = accountService.checkLogin(username, password);
            if(acc != null){
                Map session = ActionContext.getContext().getSession();
                session.put("USER", acc);
                if(acc.getRole().equals("admin")){
                    url = SUCCESS;
                }
            }
        }
        return url;
    }

    @Override
    public void setServletResponse(HttpServletResponse servletResponse) {
        this.servletResponse = servletResponse;
    }

    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }
    
}
