<%-- 
    Document   : fromSolicitarPrestamo
    Created on : 11-jun-2022, 13:05:24
    Author     : sergi
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
        <br>
        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>
        <h1 style="margin-left: 25px">Solicitar prestamo</h1>
        <br>
        
        <div class="miCuenta-form" style="margin-left: 25px">
            <s:form action="prestamoRegistrar" method="post">
            <s:textfield name="cantidad" label="Cantidad del préstamo"/>
            <s:checkbox name="hipoteca" fieldValue="true" label="Hipoteca"/>
            <s:hidden name="IBAN" value="%{#session.usuario.getIban().getIban()}"/>
            <s:submit cssClass="btn btn-danger" name="nuevoPrestamo" value="Registrar Prestamo"/>
        </s:form>
        </div>
        
        <s:form action="iniciarSesion" method="POST" style="margin-left: 25px">
            <s:hidden name="dniUsuario" value="%{#session.usuario.getDni()}"/>
            <s:hidden name="passwordUsuario" value="%{#session.usuario.getPassword()}"/>
            <s:submit style="margin-left: 25px" cssClass="btn btn-dark" value="Volver" /> 
        </s:form>
         <s:include value="/comun/footer.jsp"/>
    </body>
</html>
