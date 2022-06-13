<%-- 
    Document   : modificarCentral
    Created on : 13-jun-2022, 11:46:27
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
         <h4>Datos de la Central a modificar</h4>
        
        <s:property value="#session.cl.getNombre()" />
        <br>
        <s:property value="#session.cl.getDireccion()" />
        <br>
        <s:property value="#session.cl.getEmail()" />
        <br>
        <s:property value="#session.cl.getTelefono()" />
        
        <br><br><br>
        
        <h4>Campo para modificar datos</h4>
        
        <s:form action="modificarCentral" method="post">
            <s:hidden name="nombreCentral" value="%{#session.cl.getNombre()}"/>
            <s:textfield name="direccionCentral" label="Dirección de la Central"/>
            <s:textfield name="emailCentral" label="Email de la Central"/>
            <s:textfield name="telefonoCentral" label="Teléfono de la Central"/> 
            <s:submit name="modificarCentral" value="Modificar Central"/>
        </s:form>
        
        <s:form action="iniciarSesion" method="POST">
             <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
             <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
             <s:submit value="Volver" /> 
        </s:form>
    </body>
</html>
