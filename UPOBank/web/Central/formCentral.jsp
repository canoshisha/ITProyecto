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
        <s:head/>
    </head>
    <body>
       <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>
        <h4>Registrar una nueva Central</h4>
        
        <s:form action="centralRegistrar" method="POST">
            <s:textfield name="nombreCentral" label="nombre de la Central"/>
            <s:textfield name="direccionCentral"  label="Direccion de la Central"/>
            <s:textfield name="emailCentral" label="Email de la Central" />
            <s:textfield name="telefonoCentral" label="Teléfono de la Central" />
            <s:submit value="Registrar Central" />
        </s:form>
        <s:form action="iniciarSesion" method="POST">
             <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
             <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
             <s:submit value="Volver" /> 
        </s:form>
    </body>
</html>
