<%-- 
    Document   : crearTarjeta
    Created on : 12-jun-2022, 18:26:10
    Author     : sergi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <h1>Opciones de tarjetas</h1>
        <s:form action="createTarjeta" method="POST">
            <s:submit name="ComprobarTarjeta" value="Solicitar nueva tarjeta"/>
        </s:form>
<%-- 
        <h1>Mas opciones</h1>
        <h4>Datos de la tarjeta </h4>
        <s:form action="activarTarjeta" method="POST">
            <s:textfield name="Numero_tarjeta" label="Numero de tarjeta"/>
            <s:textfield name="caducidad" label="Caducidad"  />
            <s:textfield name="cvv" label="CVV"/>
            <s:submit name="ComprobarTarjeta" value="Activar tarjeta"/>
        </s:form>
--%>

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
                <tr>
                    <td>...</td>
                    <td>...</td>
                    <td>...</td>
                </tr>
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
