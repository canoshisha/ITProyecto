<%-- 
    Document   : modificarCuenta
    Created on : 12-jun-2022, 19:01:28
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
        <h4>Datos de la cuenta a modificar</h4>
        <h5>IBAN</h5>
        <s:property value="#session.cb.getIban()" />
        <br>
        <h5>Cantidad de la cuenta</h5>
        <s:property value="#session.cb.getCantidad()" />
        <br><br><br>
        
        <h4>Campo para modificar datos</h4>
        <div class="miCuenta">
        <div class="miCuenta-form">
        <s:form action="modificarCB" method="post">
            <s:textfield name="IBANnuevo" label="IBAN de la cuenta"/>
            <s:textfield name="cantidad" label="Cantidad"/>
            <s:hidden name="IBAN" value="%{#session.cb.getIban()}"/>
            <s:submit name="modificarCantidad" value="Modificar Cantidad"/>
        </s:form>
        </div>
        </div>
        <br>
        
        <s:form action="iniciarSesion" method="POST">
             <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
             <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
             <s:submit  value="Volver" /> 
        </s:form>
        <br><br>
        <s:include value="/comun/footer.jsp"/>
    </body>
</html>
