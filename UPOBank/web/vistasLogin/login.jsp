<%-- 
    Document   : login
    Created on : 11-jun-2022, 10:52:18
    Author     : mater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UPOBank</title>
        <s:head/>
    </head>
    <body>
        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>
        <s:form action="iniciarSesion" method="post">
            <s:textfield name="dniUsuario" label="DNI"/>
            <s:password name="passwordUsuario" label="Contraseña"/>
            <s:submit name="iniciarSesion" value="Iniciar Sesión"/>
        </s:form>
        <p>¿Aún no te has registrado?</p>
        <s:form action="regi" method="post">
            <s:submit name="registrar" value="Registrarse"/>            
        </s:form>
    </body>
</html>
