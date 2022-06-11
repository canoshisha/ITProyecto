<%-- 
    Document   : registrar
    Created on : 11-jun-2022, 11:28:09
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
        <h1></h1>
        
        <s:form action="iniciarSesion" method="post">
            <s:textfield name="dniUsuario" label="DNI"/>
            <s:textfield name="passwordUsuario" label="Contraseña"/>
            <s:submit name="iniciarSesion" value="Iniciar Sesión"/>
        </s:form>
    </body>
</html>
