<%-- 
    Document   : edit
    Created on : May 8, 2020, 1:44:26 PM
    Author     : truongtn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <s:if test="%{!#session.USER.fullname.isEmpty()}">
            Welcome, <s:property value="%{#session.USER.fullname}"/><br/>
            <a href="logout">LogOut</a>
        </s:if>
        <s:else>
            <a href="try">Login</a>
        </s:else><h1>Hello World!</h1>
        <s:form action="update" method="post" value="menu">
            <s:textfield label="Food ID" name="foodId" value="%{menu.foodId}" readonly="true"/>
            <s:textfield label="Food Name" name="name" value="%{menu.name}"/>
            <s:textfield label="Price" name="price" value="%{menu.price}"/>
            <s:combobox label="Category" name="category" list="categoryList" value="%{menu.category}"/>
            <s:textfield label="Quantity" name="quantity" value="%{menu.quantity}"/>
            <s:select label="Status" list="{'active', 'inactive'}"/>
            <s:submit value="Update"/>
            <s:reset value="Reset"/>
        </s:form>
    </body>
</html>
