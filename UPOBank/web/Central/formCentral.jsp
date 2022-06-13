<%-- 
    Document   : formCentral
    Created on : 13-jun-2022, 11:41:14
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
        <h1>Nueva Central</h1>
        <br>
        
        <div class="miCuenta-form" style="margin-left: 25px">
            <s:form action="centralRegistrar" method="POST">
            <s:textfield name="nombreCentral" label="Nombre de la Central"/>
            <s:textfield name="direccionCentral"  label="Direccion de la Central"/>
            <s:textfield name="emailCentral" label="Email de la Central" />
            <s:textfield name="telefonoCentral" label="Teléfono de la Central" />
            <s:submit cssClass="btn btn-danger" value="Registrar Central" />
        </s:form>
        </div>
        <s:form action="iniciarSesion" method="POST">
             <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
             <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
             <s:submit cssClass="btn btn-dark" value="Volver" /> 
        </s:form>
        <s:include value="/comun/footer.jsp"/>
    </body>
</html>
