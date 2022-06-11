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
        <h1>Bienvenido JOSELITO</h1>
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
                    <td>...</td>
                    <td>...€</td>
                </tr>
            </tbody>
        </table>
        <br>
        <h4>Ultimos movimientos por Bizum</h4>
        <table border="1">
            <thead>
                <tr>
                    <th>Movil destinatario</th>
                    <th>Fecha</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>..</td>
                    <td>..</td>
                    <td>..</td>
                </tr>
            </tbody>
        </table>
        <s:form action="bizumform" method="POST">
            <s:hidden name="IBAN" value="AQUI PONERMOS EL VALOR DEL IBAN"/>
            <s:submit name="realizarBizum" value="Realizar Bizum"/>
        </s:form>
        
        <h4>Ultimas transferencias</h4>
        <table border="1">
            <thead>
                <tr>
                    <th>IBAN destinatario</th>
                    <th>Fecha realizada</th>
                    <th>Fecha recibida</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>..</td>
                    <td>fecha inicio</td>
                    <td>fecha fin</td>
                    <td>..</td>
                </tr>
            </tbody>
        </table>
        <s:form action="transform" method="POST">
            <s:hidden name="IBAN" value="AQUI PONERMOS EL VALOR DEL IBAN"/>
            <s:submit name="realizarTransferencia" value="Realizar transferencia"/>
        </s:form>
        
        
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
        <s:form action="solPresform" method="POST">
            <s:hidden name="IBAN" value="AQUI PONERMOS EL VALOR DEL IBAN"/>
            <s:submit name="solicitarPrestamo" value="Solicitar un prestamos"/>
        </s:form>
        
        
        
    </body>
</html>
