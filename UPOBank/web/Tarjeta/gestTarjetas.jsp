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
        <s:head/>
    </head>
    <body>
           <h1>Opciones de tarjetas</h1>
        <s:form action="createTarjeta" method="POST">
            <s:hidden name="IBAN" value="%{#session.usuario.getIban().getIban()}"/>
            <s:hidden name="dniUsuario" value="%{#session.usuario.getDni()}"/>
            <s:submit name="ComprobarTarjeta" value="Solicitar nueva tarjeta"/>
        </s:form>

        <h2>Tarjetas disponibles</h2>
        <table border="1">
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
        <s:form action="iniciarSesion" method="POST">
            <s:hidden name="dniUsuario" value="%{#session.usuario.getDni()}"/>
            <s:hidden name="passwordUsuario" value="%{#session.usuario.getPassword()}"/>
            <s:submit value="Volver" /> 
        </s:form>
    </body>
</html>