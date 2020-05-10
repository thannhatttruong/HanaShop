/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.action;

import java.util.List;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import truongtn.menu.MenuDTO;
import truongtn.menu.MenuService;

/**
 *
 * @author truongtn
 */
@ResultPath("/")
@Result(name = "success", location = "admin.jsp")
public class FindAction {
    private String searchValue;
    private List<MenuDTO> itemList; 
    private final String SUCCESS = "success";
    public FindAction() {
    }
    
    public String execute() throws Exception {
        String url = SUCCESS;
        MenuService menuService = new MenuService();
        if(searchValue.isEmpty()){
            menuService.loadAdminPage();
        }else{
            menuService.findLikeFoodName(searchValue);
        }
        itemList = menuService.getItemList();
        return url;
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    /**
     * @return the itemList
     */
    public List<MenuDTO> getItemList() {
        return itemList;
    }

    /**
     * @param itemList the itemList to set
     */
    public void setItemList(List<MenuDTO> itemList) {
        this.itemList = itemList;
    }
    
    
}
