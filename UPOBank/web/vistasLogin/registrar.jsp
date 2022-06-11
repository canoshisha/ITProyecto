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
        <h1>Datos para registrarse</h1>       
        <s:form action="RegistrarUsuario" method="post">
            <s:textfield name="dniUsuario" label="DNI"/>
            <s:textfield name="nombreCompleto" label="Nombre Completo"/>
            <s:textfield name="passwordUsuario" label="Contraseña"/>
            <s:textfield name="direccionUsuario" label="Dirección Usuario"/>
            <s:textfield name="movilUsuario" label="Teléfono móvil"/> 
            <s:select label="Seleccione la dirección de la sucursal" 
                      headerValue="Direccion Sucursal"
                      list="#{'1':'Calle Rojo 5', '2':'Calle Verde 3', '3':'Calle Azul 9'}" 
                      name="direccionSucursal"/>
            <s:submit name="RegistrarUsuario" value="Registrar Usuario"/>
        </s:form>
    </body>
</html>
