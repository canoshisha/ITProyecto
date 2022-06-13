<%-- 
    Document   : formAdministrador
    Created on : 13-jun-2022, 10:06:17
    Author     : mater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<s:include value="/comun/headers.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <br>
        <h1 style="margin-left: 25px">Datos para registrarse</h1>    

        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>

        <s:form action="RegistrarAdm" method="post" style="margin-left: 25px">
            <s:textfield name="dniAdm" label="DNI"/>
            <s:textfield name="nombreCompleto" label="Nombre Completo"/>
            <s:password name="passwordAdm" label="Contraseña"/>
            <s:textfield name="direccionAdm" label="Dirección Administrador"/>
            <s:textfield name="movilAdm" label="Teléfono móvil"/> 
            <s:submit name="registrarAdm" value="Registrar Administrador"/>
        </s:form>
        <s:include value="/comun/footer.jsp"/>
    </body>
</html>
