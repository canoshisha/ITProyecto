<%-- 
    Document   : cuentaBancaria
    Created on : 11-jun-2022, 11:46:31
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
        <h1>Bienvenido <s:property value="#session.usuario.getNombreCompleto()"/> </h1>
        <h4>Tu sucursal es .... </h4>

        <table border="1">
            <thead>
                <tr>
                    <th>IBAN</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><s:property value="#session.usuario.getIban().getIban()"/> </td>
                    <td><s:property value="#session.usuario.getIban().getCantidad()"/>€</td>
                </tr>
            </tbody>
        </table>
        <br>
        <h4>Ultimos movimientos de la cuenta</h4>
        <table border="1">
            <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Concepto</th>
                    <th>Bizum/Transferencia</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>..</td>
                    <td>..</td>
                    <td>..</td>
                    <td>..</td>
                </tr>
            </tbody>
        </table>
        <br></br>
        <s:form action="bizumform" method="POST">
            <s:submit name="realizarBizum" value="Realizar Bizum"/>
        </s:form>

        <s:form action="transform" method="POST">
            <s:submit name="realizarTransferencia" value="Realizar transferencia"/>
        </s:form>
        
        <h5>Ingresos en los ultimos 30 días: ..</h5>
        <h5>Gastos en los ultimos 30 días: ..</h5>
        <h5>Saldo Actual: .. </h5>
        
        <h4>Ultimos prestamos</h4>
        <table border="1">
            <thead>
                <tr>
                    <th>Inicio</th>
                    <th>Fin</th>
                    <th>Mensualidad</th>
                    <th>¿Es hipoteca?</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>..</td>
                    <td>fecha inicio</td>
                    <td>fecha fin</td>
                    <td>..</td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        <br></br>

        <s:form action="solPresform" method="POST">
            <s:hidden name="IBAN" value="AQUI PONERMOS EL VALOR DEL IBAN"/>
            <s:submit name="solicitarPrestamo" value="Solicitar un prestamos"/>
        </s:form>
        <%-- 
     <s:form action="Tarjetaform" method="POST">
            <s:submit name="verTarjetas" value="Tarjetas"/>
        </s:form>
--%>
       
        
    </body>
</html>
