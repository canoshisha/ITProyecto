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
        <title>Pagina Principal Usuarios</title>
        <s:include value="/comun/headers.jsp"/>
        <s:head/>
    </head>
    <body>
        <br>
        <h1 style="margin-left: 25px">Bienvenido <s:property value="#session.usuario.getNombreCompleto()"/> </h1>
        <h4 style="margin-left: 25px">Tu sucursal se encuentra en  <s:property value="#session.usuario.getIdSucursal().getDireccion()"/> </h4>

        <table   style="margin-left: 25px" class="table table-striped table-hover">
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
        <h4  style="margin-left: 25px">Ultimos movimientos de la cuenta</h4>
        <table  style="margin-left: 25px" class="table table-striped table-hover">
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
        <br>
        <s:form action="bizumform" method="POST"  style="margin-left: 25px">
            <s:submit style="margin-left: 25px" cssClass="btn btn-danger" name="realizarBizum" value="Realizar Bizum"/>
        </s:form>

        <s:form action="transform" method="POST"  style="margin-left: 25px">
            <s:submit style="margin-left: 25px" cssClass="btn btn-danger" name="realizarTransferencia" value="Realizar transferencia"/>
        </s:form>
        <br>
        <h4  style="margin-left: 25px">Ultimos prestamos</h4>
        <table class="table table-striped table-hover"  style="margin-left: 25px">
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
        <br>

        <s:form action="solPresform" method="POST"  style="margin-left: 25px">
            <s:submit style="margin-left: 25px" cssClass="btn btn-danger" value="Solicitar un prestamos"/>
        </s:form>
        <br>
        <h4 style="margin-left: 25px">Gestionar tarjetas</h4>
        <s:form action="gesTarjetas" method="POST"  style="margin-left: 25px">
            <s:submit style="margin-left: 25px" cssClass="btn btn-danger" name="gestionarTarjetas" value="Gestionar tarjetas"/>
        </s:form>


        <br></br>
        <s:form action="cerrarSesion" method="POST"  style="margin-left: 25px">
            <s:submit  style="margin-left: 25px" cssClass="btn btn-dark" name="logOutAction" value="Cerrar Sesión"/>
        </s:form>
        <s:include value="/comun/footer.jsp"/>
    </body>
</html>
