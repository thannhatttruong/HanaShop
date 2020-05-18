/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.action;

import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
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
    @Result(name = "success", location = "login.html"),
    @Result(name = "fail", location = "insertErr.jsp"),
    @Result(name = "input", location = "registry.jsp")
})
public class CreateAccountAction {

    private String username;
    private String password;
    private String fullname;
    private String confirm;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public CreateAccountAction() {
    }

    @Action(value = "createAccount",
            exceptionMappings = {
            @ExceptionMapping(exception = "java.sql.SQLException", result = "input")
    })
    
    public String execute() throws Exception {
        String url = FAIL;
        AccountService accountService = new AccountService();
        AccountDTO accountDTO = new AccountDTO(username, password, fullname, "user");
        boolean result = accountService.createAnAccount(accountDTO);
        if (result) {
            url = SUCCESS;
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
    @RequiredStringValidator(trim = true, message = "Username is required", key = "insert.username.required")
    @StringLengthFieldValidator(minLength = "3", maxLength = "20", message = "Username length must be 3 -20 chars", key = "insert.username.length")
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
    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Password is required")
    @StringLengthFieldValidator(type = ValidatorType.FIELD, minLength = "3", maxLength = "20", message = "Password length must be 6 -20", key = "insert.password.length")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    @RequiredStringValidator(trim = true, message = "Fullname is required", key = "insert.fullname.required")
    @StringLengthFieldValidator(minLength = "3", maxLength = "30", message = "Fullname length must be 3 - 30 chars", key = "insert.fullname.length")
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the confirm
     */
    public String getConfirm() {
        return confirm;
    }

    /**
     * @param confirm the confirm to set
     */
    @FieldExpressionValidator(expression = "confirm==password", message = "Confirm must match Password")
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

}
