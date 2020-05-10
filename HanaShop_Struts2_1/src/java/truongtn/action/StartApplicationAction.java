/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.action;

import javax.ws.rs.Path;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author truongtn
 */
@Path("/")
@Action(value = "", results = {
    @Result(name = "success", type = "redirectAction", params = {"actionName", "search", "searchValue", ""}),
    @Result(name = "fail", type = "redirectAction", params = {"actionName", "search", "searchValue", ""})
})
public class StartApplicationAction {
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public StartApplicationAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
}
