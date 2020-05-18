/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import truongtn.menu.MenuService;

/**
 *
 * @author truongtn
 */
@ResultPath("/")
@Results({
    @Result(name = "success", type = "redirectAction", params = {"actionName", "find", "searchValue", "${lastSearchValue}"}),
    @Result(name = "fail", type = "redirect", location = "error.html")
})
public class RemoveAction {
    private String pk;
    private String lastSearchValue;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public RemoveAction() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        MenuService menuService = new MenuService();
        boolean result = menuService.removeItem(pk);
        if(result){
            url = SUCCESS;
        }
        return url;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
}
