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
@Result(name = "success", location = "home.jsp")
public class SearchAction {
    private String searchValue;
    private List<MenuDTO> itemList; 
    private final String SUCCESS = "success";
    
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        String url = SUCCESS;
        MenuService menuService = new MenuService();
        if(searchValue.trim().isEmpty()){
            menuService.loadHomePage();
        }else{
            menuService.searchLikeFoodName(searchValue);
        }
        itemList = menuService.getItemList();
        
        return url;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<MenuDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<MenuDTO> itemList) {
        this.itemList = itemList;
    }
    
}
