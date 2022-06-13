<%-- 
    Document   : crearTarjeta
    Created on : 12-jun-2022, 18:26:10
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
        <h1 style="margin-left: 25px">Tarjetas</h1>
        <br>
        
        <div class="miCuenta-form" style="margin-left: 25px">
            <s:form action="createTarjeta" method="POST">
            <s:hidden name="IBAN" value="%{#session.usuario.getIban().getIban()}"/>
            <s:hidden name="dniUsuario" value="%{#session.usuario.getDni()}"/>
            <s:submit cssClass="btn btn-danger" name="ComprobarTarjeta" value="Solicitar nueva tarjeta"/>
        </s:form>
        </div>
           


        <h2 style="margin-left: 25px">Tarjetas disponibles</h2>
        <table style="margin-left: 25px" class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>Numero de la tarjeta</th>
                    <th>Caducidad</th>
                    <th>cvv</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.listaTarjetas">
                    <s:if test="getIban().getIban() == #session.usuario.getIban().getIban()"> 
                <tr>
                    <td><s:property value="getNumerotarjeta()"/></td>
                    <td><s:property value="getCaducidad()"/></td>
                    <td><s:property value="getCvv()"/></td>
                </tr>
                     </s:if>
                </s:iterator>
            </tbody>
        </table>
        <br>
        <s:form action="iniciarSesion" method="POST" style="margin-left: 25px">
            <s:hidden name="dniUsuario" value="%{#session.usuario.getDni()}"/>
            <s:hidden name="passwordUsuario" value="%{#session.usuario.getPassword()}"/>
            <s:submit style="margin-left: 25px" cssClass="btn btn-dark" value="Volver" /> 
        </s:form>
        <s:include value="/comun/footer.jsp"/>
    </body>
</html>