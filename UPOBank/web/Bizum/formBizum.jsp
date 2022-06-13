<%-- 
    Document   : formBizum
    Created on : 11-jun-2022, 13:00:22
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
        
        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>
        <h1>Realizar Bizum</h1>
        <br>
        
        <div class="miCuenta-form" style="margin-left: 25px">
            <s:form action="bizumRegistrar" method="POST">
            <s:textfield name="movilDest" label="Movil destinatario"/>
            <s:textfield name="cantidad"  label="Cantidad"/>
            <s:textfield name="concepto" label="Concepto" />
            <s:hidden name="IBAN" value="%{#session.usuario.getIban().getIban()}"/>
            <s:submit cssClass="btn btn-danger" value="Realizar Bizum" />
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
