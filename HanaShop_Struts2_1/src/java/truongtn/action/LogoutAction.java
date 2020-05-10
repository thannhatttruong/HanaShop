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

/**
 *
 * @author truongtn
 */
@ResultPath("/")
@Result(name = "success", type = "redirectAction", params = {"actionName", "search", "searchValue", ""})
public class LogoutAction {
    
    public LogoutAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        session.remove("USER");
        
        return "success";
        
    }
    
}
