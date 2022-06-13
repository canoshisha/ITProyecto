<%-- 
    Document   : modificarAdm
    Created on : 13-jun-2022, 13:45:02
    Author     : Carlos Herrera
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
         <h4>Datos del Administrador a modificar</h4>
        
        <s:property value="#session.adm.getDni()" />
        <br>
        <s:property value="#session.adm.getNombreCompleto()" />
        <br>
        <s:property value="#session.adm.getPassword()" />
        <br>
        <s:property value="#session.adm.getDireccion()" />
        <br>
        <s:property value="#session.adm.getMovil()" />
        <br><br><br>
        
        <h4>Campo para modificar datos</h4>
        
        <s:form action="modificarAdm" method="post">
            <s:hidden name="dniAdministrador" value="%{#session.adm.getDni()}"/>
            <s:textfield name="nombreCompleto" label="Nombre Completo"/>
            <s:password name="passwordAdministrador" label="Contraseña"/>
            <s:textfield name="direccionAdministrador" label="Dirección Administrador"/>
            <s:textfield name="movilAdministrador" label="Teléfono móvil"/> 
            <s:submit name="modificarAdministrador" value="Modificar Administrador"/>
        </s:form>
        
        <s:form action="iniciarSesion" method="POST">
             <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
             <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
             <s:submit value="Volver" /> 
        </s:form>
    </body>
</html>
