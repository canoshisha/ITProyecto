<%-- 
    Document   : formTarjetas
    Created on : 11-jun-2022, 17:54:55
    Author     : alvip
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
        <h1>Opciones de tarjetas</h1>
        <s:form action="nuevaTarjeta" method="POST">
            <s:submit name="ComprobarTarjeta" value="Solicitar nueva tarjeta"/>
             <s:hidden name="IBAN" value="AQUI VA LA VARIABLE IBAN"/>
        </s:form>

        <h1>Mas opciones</h1>
        <h4>Datos de la tarjeta </h4>
        <s:form action="activarTarjeta" method="POST">
            <s:textfield name="Numero_tarjeta" label="Numero de tarjeta"/>
            <s:textfield name="caducidad" label="Caducidad"  />
            <s:textfield name="cvv" label="Cvv"/>
             <s:hidden name="IBAN" value="AQUI VA LA VARIABLE IBAN"/>
            <s:submit name="ComprobarTarjeta" value="Activar tarjeta"/>
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
                <tr>
                    <td>...</td>
                    <td>...</td>
                    <td>...</td>
                    <td><s:form action="bloquearTarjeta" method="POST">
                            <s:submit name="ComprobarTarjeta" value="Bloquear tarjeta"/>
                             <s:hidden name="IBAN" value="AQUI VA LA VARIABLE IBAN"/>
                        </s:form></td>
                </tr>
            </tbody>
        </table>
        <br>
    </body>
</html>
