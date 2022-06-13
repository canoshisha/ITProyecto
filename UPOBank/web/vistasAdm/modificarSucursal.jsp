<%-- 
    Document   : modificarPrestamo
    Created on : 12-jun-2022, 19:01:49
    Author     : mater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
         <h4>Datos de la Sucursal a modificar</h4>
        
        Dirección de la Sucursal: <s:property value="#session.suc.getDireccion()" />
        <br><br><br>
        
        <h4>Campo para modificar datos</h4>
        
        <s:form action="modificarUsr" method="post">
            <s:hidden name="idSucursal" value="%{#session.suc.getId()}"/>
            <s:textfield name="nombreCompleto" label="Nombre Completo"/>
            <s:submit name="modificarSucursal" value="Modificar Sucursal"/>
        </s:form>
        
        <s:form action="iniciarSesion" method="POST">
             <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
             <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
             <s:submit value="Volver" /> 
        </s:form>
    </body>
</html>
