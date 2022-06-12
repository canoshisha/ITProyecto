<%-- 
    Document   : formTranferencia
    Created on : 11-jun-2022, 13:03:32
    Author     : sergi
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
        <s:form action="transferenciaRegistrar" method="POST">
            <s:textfield name="IBAN_dest" label="IBAN destinatario "/>
            <s:textfield name="cantidad"  label="Cantidad"/>
            <s:textfield name="concepto" label="Concepto" />
            <s:hidden name="IBAN" value="%{#session.usuario.getIban().getIban()}"/>
            <s:submit value="Realizar transferencia" />
        </s:form>
        <s:form action="iniciarSesion" method="POST">
            <s:hidden name="dniUsuario" value="%{#session.usuario.getDni()}"/>
            <s:hidden name="passwordUsuario" value="%{#session.usuario.getPassword()}"/>
            <s:submit value="Volver" /> 
        </s:form>
    </body>
</html>
