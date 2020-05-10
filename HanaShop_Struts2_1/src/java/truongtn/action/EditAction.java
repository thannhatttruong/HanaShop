/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.action;

import java.util.List;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import truongtn.menu.MenuDTO;
import truongtn.menu.MenuService;

/**
 *
 * @author truongtn
 */
@ResultPath("/")
@Results({
    @Result(name = "success", location = "edit.jsp"),
    @Result(name = "fail", type = "redirect", location = "error.html")
})
public class EditAction {
    private String pk;
    private String lastSearchValue;
    private MenuDTO menu;
    private List<String> categoryList;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    
    public EditAction() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        
        MenuService menuService = new MenuService();
        menu = menuService.getItemByID(pk);
        if(menu != null){
            setCategoryList(menuService.getAllCategory());
            url = SUCCESS;
        }
        return url;
    }

    /**
     * @return the pk
     */
    public String getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(String pk) {
        this.pk = pk;
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

    /**
     * @return the menu
     */
    public MenuDTO getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(MenuDTO menu) {
        this.menu = menu;
    }

    /**
     * @return the categoryList
     */
    public List<String> getCategoryList() {
        return categoryList;
    }

    /**
     * @param categoryList the categoryList to set
     */
    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

}
