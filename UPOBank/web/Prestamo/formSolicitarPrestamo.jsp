<%-- 
    Document   : fromSolicitarPrestamo
    Created on : 11-jun-2022, 13:05:24
    Author     : sergi
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
        <s:form action="prestamoRegistrar" method="post">
            <s:textfield name="cantidad" label="Cantidad del préstamo"/>
            <s:checkbox name="hipoteca" fieldValue="true" label="Hipoteca"/>
            <s:hidden name="IBAN" value="%{#session.usuario.getIban().getIban()}"/>
            <s:submit name="nuevoPrestamo" value="Registrar Prestamo"/>
        </s:form>
        <s:form action="iniciarSesion" method="POST">
            <s:hidden name="dniUsuario" value="%{#session.usuario.getDni()}"/>
            <s:hidden name="passwordUsuario" value="%{#session.usuario.getPassword()}"/>
            <s:submit value="Volver" /> 
        </s:form>
    </body>
</html>
