<%-- 
    Document   : modificarUsr
    Created on : 12-jun-2022, 19:01:03
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
        <h4>Datos del Usuario a modificar</h4>
        
        <s:property value="#session.usr.getDni()" />
        <br>
        <s:property value="#session.usr.getNombreCompleto()" />
        <br>
        <s:property value="#session.usr.getPassword()" />
        <br>
        <s:property value="#session.usr.getDireccion()" />
        <br>
        <s:property value="#session.usr.getMovil()" />
        <br><br><br>
        
        <h4>Campo para modificar datos</h4>
        
        <s:form action="modificarUsr" method="post">
            <s:hidden name="dniUsuario" value="%{#session.usr.getDni()}"/>
            <s:textfield name="nombreCompleto" label="Nombre Completo"/>
            <s:password name="passwordUsuario" label="Contraseña"/>
            <s:textfield name="direccionUsuario" label="Dirección Usuario"/>
            <s:textfield name="movilUsuario" label="Teléfono móvil"/> 
            <s:submit name="modificarUsuario" value="Modificar Usuario"/>
        </s:form>
        
        <s:form action="iniciarSesion" method="POST">
             <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
             <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
             <s:submit value="Volver" /> 
        </s:form>
        
        
    </body>
</html>
