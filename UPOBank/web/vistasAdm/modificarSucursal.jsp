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
        <s:include value="/comun/headers.jsp"/>
    </head>
    <body>

        <h4 style="margin-left: 25px">Datos de la Sucursal a modificar</h4>
        <div class="modificarSucursal-form" style="margin-left: 25px" >
            Dirección de la Sucursal: <s:property  value="#session.suc.getDireccion()" />
            <br><br><br>
        </div>
            <h4 style="margin-left: 25px">Campo para modificar datos</h4>

            <s:form action="modificarSucursal" method="post" style="margin-left: 25px">
                <s:hidden name="idSucursal" value="%{#session.suc.getId()}"/>
                <s:textfield name="direccionSucursal" label="Direccion de la Sucursal"/>
                <s:submit cssClass="btn btn-danger"  name="modificarSucursal" value="Modificar Sucursal"/>
            </s:form>

            <s:form action="iniciarSesion" method="POST" style="margin-left: 25px">
                <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
                <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
                <s:submit  style="margin-left: 25px"cssClass="btn btn-dark" value="Volver" /> 
            </s:form>
        
        <s:include value="/comun/footer.jsp"/>
    </body>
</html>
