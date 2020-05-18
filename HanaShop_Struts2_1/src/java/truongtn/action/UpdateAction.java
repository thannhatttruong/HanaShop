/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.action;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
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
    @Result(name = "success", type = "redirectAction", params = {"actionName", "find", "searchValue", "${searchValue}"}),
    @Result(name = "fail", type = "redirect", location = "updateMenuErr.html"),
    @Result(name = "input", type = "redirect", location = "edit.jsp")
})
public class UpdateAction {

    private String foodId;
    private String name;
    private int price;
    private String category;
    private int quantity;
    private String status;
    private String searchValue;

    private static String SUCCESS = "success";
    private static String FAIL = "fail";

    public UpdateAction() {
    }

    @Action(value = "update",
            exceptionMappings = {
                @ExceptionMapping(exception = "java.sql.SQLException", result = "input")
            })

    public String execute() throws Exception {
        String url = FAIL;
        System.out.println("CATEGORY: " + category);
        System.out.println("Status: " + status);
        System.out.println("Price: " + price);
        MenuDTO menu = new MenuDTO(foodId, name, null, price, category, quantity, status);
        MenuService menuService = new MenuService();
        boolean result = menuService.updateAnItem(menu);
        if (result) {
            url = SUCCESS;
        }
        return url;
    }

    /**
     * @return the foodId
     */
    public String getFoodId() {
        return foodId;
    }

    /**
     * @param foodId the foodId to set
     */
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @RequiredStringValidator(trim = true,
            message = "Food name is required",
            key = "insert.username.required")
    @StringLengthFieldValidator(minLength = "3", maxLength = "20",
            message = "FoodName length is required 3 - 20 chars",
            key = "insert.foodName.length")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    @IntRangeFieldValidator(type = ValidatorType.FIELD, min = "0", message = "Price is an integer and greater than 0.")
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    @IntRangeFieldValidator(type = ValidatorType.FIELD, min = "0", message = "Price is an integer and greater than 0.")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
