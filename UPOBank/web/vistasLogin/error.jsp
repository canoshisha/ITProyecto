<%-- 
    Document   : error
    Created on : 11-jun-2022, 11:27:23
    Author     : mater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p style="color: red">Usuario incorrecto</p>
        
        <s:form action="volverLogin" method="post">
            <s:submit name="VolverLogin" value="Volver Login"/>
        </s:form>
        
        <!--<a href="login.jsp">Volver login</a>-->
    </body>
</html>
