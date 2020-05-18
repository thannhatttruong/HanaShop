<%-- 
    Document   : registry
    Created on : May 5, 2020, 11:50:38 AM
    Author     : truongtn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registry page</title>
        <s:head/>
    </head>
    <body>
        <h1>Hello World!</h1>
        <s:form action="createAccount" method="Post">
            <s:textfield label="Username" name="username"/>
            <s:if test="%{exception.message.indexOf('duplicate') > -1}">
                <font color="red">
                <s:property value="username"/> is existed
                </font>
            </s:if>
            <s:password label="Password" name="password"/>
            <s:password label="Confirm" name="confirm"/>
            <s:textfield label="Fullname" name="fullname"/>
            <s:submit value="Registry"/>
            <s:reset value="Reset"/>
        </s:form>
    </body>
</html>
