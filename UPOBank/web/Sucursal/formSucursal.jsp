<%-- 
    Document   : formSucursal
    Created on : 13-jun-2022, 12:55:14
    Author     : mater
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:include value="/comun/headers.jsp"/>
        <s:head/>
    </head>
    <body>

       <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>
        <h1>Nueva Sucursal</h1>
        <br>
        
        <div class="miCuenta-form" style="margin-left: 25px">
            <s:form action="sucursalRegistrar" method="POST">
            <s:textfield name="direccionSucursal" label="Direccion de la Sucursal"/>
            <s:select label="Seleccione la dirección del banco" 
                      headerValue="Direccion Central"
                     list="listaNombreCentral"
                     headerKey="-1"
                      name="nombreCentral"/>
            <s:submit cssClass="btn btn-danger" value="Registrar Sucursal" />
        </s:form>
        </div>
        
        
        <s:form action="iniciarSesion" method="POST">
             <s:hidden name="dniUsuario" value="%{#session.usuario.getDni()}"/>
             <s:hidden name="passwordUsuario" value="%{#session.usuario.getPassword()}"/>
             <s:submit cssClass="btn btn-dark" value="Volver" /> 
        </s:form>
        <s:include value="/comun/footer.jsp"/>
    </body>
</html>
