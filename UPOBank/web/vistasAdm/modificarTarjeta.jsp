<%-- 
    Document   : modificarTarjeta
    Created on : 12-jun-2022, 19:01:15
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

        <h4>Datos de la Tarjeta a modificar</h4>

        <table class="table table-striped table-hover"> 
            <thead>
            <th>Numero de Tarjeta</th>
            <th>Caducidad</th>
            <th>Cvv</th>
        </thead>
        <tbody>
            <tr>
                <td>
                    <s:property value="#session.tj.getNumerotarjeta()" />
                </td>
                <td>
                    <s:property value="#session.tj.getCaducidad()" />
                </td>
                <td>
                    <s:property value="#session.tj.getCvv()" />
                </td>
            </tr>
        </tbody>
    </table>

    <br><br><br>

    <h4>Campo para modificar datos</h4>

    <div class="miTarjeta">
        <div class="miTarjeta-form">
            <s:form action="modificarTar" method="post" style="margin-left: 25px">
                <s:hidden name="numeroTarjeta" value="%{#session.tj.getNumerotarjeta()}"/>
                <s:hidden name="caducidadTarjeta" label="%{#session.tj.getCaducidad()}"/>
                <s:textfield name="cvv" label="CVV"/>
                <s:submit cssClass="btn btn-danger"  name="modificarTarjeta" value="Modificar Tarjeta"/>
            </s:form>
            </div>
        </div>

        <s:form action="iniciarSesion" method="POST">
            <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
            <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
            <s:submit value="Volver" /> 
        </s:form>
        <s:include value="/comun/footer.jsp"/>
</body>
</html>
