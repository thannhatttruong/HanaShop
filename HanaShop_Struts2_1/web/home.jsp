<%-- 
    Document   : home
    Created on : May 5, 2020, 11:50:25 AM
    Author     : truongtn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:if test="%{!#session.USER.fullname.isEmpty()}">
            Welcome, <s:property value="%{#session.USER.fullname}"/><br/>
            <a href="logout">LogOut</a>
        </s:if>
        <s:else>
            <a href="try">Login</a>
        </s:else>
        <s:form action="search">
            <s:textfield name="searchValue" label="SearchValue"/>
            <s:submit value="Search"/>
        </s:form>
        <s:if test="%{itemList != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Food Id</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Update Date</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="itemList" status="counter">
                        <tr>
                            <td>
                                <s:property value="%{#counter.count}"/>
                            </td>
                            <td>
                                <s:property value="foodId"/>
                            </td>
                            <td>
                                <s:property value="name"/>
                            </td>
                            <td>
                                <s:property value="category"/>
                            </td>
                            <td>
                                <s:property value="price"/>
                            </td>
                            <td>
                                <s:property value="quantity"/>
                            </td>
                            <td>
                                <s:property value="updateDate"/>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>

    </body>
</html>
