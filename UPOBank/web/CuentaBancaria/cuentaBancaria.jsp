<%-- 
    Document   : cuentaBancaria
    Created on : 11-jun-2022, 11:46:31
    Author     : sergi
--%>

<%@page import="Entidades_REST.Prestamo"%>
<%@page import="Entidades_REST.Transferencia"%>
<%@page import="Entidades_REST.Bizum"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
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
        <h4>Tu sucursal se encuentra en  <s:property value="#session.usuario.getIdSucursal().getDireccion()"/> </h4>
        <s:form action="formTarjeta" method="POST">
            <s:submit name="verTarjetas" value="Tarjetas"/>
        </s:form>

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
                    <th>Bizum/Transferencia</th>
                    <th>Concepto</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.listaBizum">
                    <s:if test="getIban().getIban() == #session.usuario.getIban().getIban()">
                    <tr>
                        <td><s:property value="getFecha()"/> </td>
                        <td>Bizum</td>
                        <td><s:property value="getConcepto()"/></td>
                        <td><s:property value="getCantidad()"/></td>
                    </tr>
                    </s:if>
                </s:iterator>
                   
                <s:iterator value="#session.listaTransferencia">
                    <s:if test="getIban().getIban() == #session.usuario.getIban().getIban()"> 
                    <tr>
                        <td><s:property value="getFechaInicio()"/> </td>
                        <td>Transferencia</td>
                        <td><s:property value="getConcepto()"/></td>
                        <td><s:property value="getCantidad()"/></td>
                    </tr>
                    </s:if>
                </s:iterator>
            </tbody>
        </table>
        <br></br>
        <s:form action="bizumform" method="POST">
            <s:submit name="realizarBizum" value="Realizar Bizum"/>
        </s:form>

        <s:form action="transform" method="POST">
            <s:submit name="realizarTransferencia" value="Realizar transferencia"/>
        </s:form>
        <br>
        <br>
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
                <s:iterator value="#session.listaPrestamo">
                    <s:if test="getIban().getIban() == #session.usuario.getIban().getIban()">
                    <tr>
                        <td><s:property value="getInicio()"/> </td>
                        <td><s:property value="getFin()"/></td>
                        <td><s:property value="getMensualidad()"/></td>
                        <td><s:property value="getHipoteca()"/></td>
                        <td><s:property value="getCantidad()"/></td>
                    </tr>
                    </s:if>
                </s:iterator>
            </tbody>
        </table>
        <br></br>

        <s:form action="solPresform" method="POST">
            <s:submit name="solicitarPrestamo" value="Solicitar un prestamos"/>
        </s:form>
        
        <s:form action="gesTarjetas" method="POST">
             <s:submit name="gestionarTarjetas" value="Gestionar tarjetas"/>
        </s:form>
        
        
        <br></br>
         <s:form action="cerrarSesion" method="POST">
            <s:submit name="logOutAction" value="Cerrar Sesión"/>
        </s:form>

    </body>
</html>
