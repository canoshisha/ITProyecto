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
        <s:head/>
        <s:include value="/comun/headers.jsp"/>
    </head>
    <body>
        <br>
        <h1 style="margin-left: 25px">Datos para registrarse</h1>    
        
        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>
        
        <s:form action="RegistrarUsuario" method="post" style="margin-left: 25px">
            <s:textfield name="dniUsuario" label="DNI"/>
            <s:textfield name="nombreCompleto" label="Nombre Completo"/>
            <s:password name="passwordUsuario" label="Contraseña"/>
            <s:textfield name="direccionUsuario" label="Dirección Usuario"/>
            <s:textfield name="movilUsuario" label="Teléfono móvil"/> 
            <s:select label="Seleccione la dirección de la sucursal" 
                      headerValue="Direccion Sucursal"
                     list="listaDirecciones"
                     headerKey="-1"
                      name="direccionSucursal"/>
            <s:submit style="margin-left: 25px" cssClass="btn btn-danger"  name="registrarUsuario" value="Registrar Usuario"/>
        </s:form>
    </body>
</html>
