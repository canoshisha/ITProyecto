<%-- 
    Document   : modificarUsr
    Created on : 12-jun-2022, 19:01:03
    Author     : mater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
        <s:include value="/comun/headers.jsp"/>
    </head>
    <body>
        <h4>Datos del Usuario a modificar</h4>

        <table class="table table-striped table-hover"> 
            <thead>
            <th>DNI</th>
            <th>Nombre Completo</th>
            <th>Password</th>
            <th>Direccion</th>
            <th>Movil</th>
        </thead>
        <tbody>
            <tr>
                <td>
                    <s:property value="#session.usr.getDni()" />
                </td>
                <td>
                    <s:property value="#session.usr.getNombreCompleto()" />
                </td>
                <td>
                    <s:property value="#session.usr.getPassword()" />
                </td>
                <td>
                    <s:property value="#session.usr.getDireccion()" />
                </td>
                <td>
                    <s:property value="#session.usr.getMovil()" />
                </td>
            </tr>

        </tbody>
    </table>


    <h4>Campo para modificar datos</h4>

    <div class="miUsr">
        <div class="miUsr-form">
            <s:form action="modificarUsr" method="post" style="margin-left: 25px">
                <s:hidden name="dniUsuario" value="%{#session.usr.getDni()}"/>
                <s:textfield name="nombreCompleto" label="Nombre Completo"/>
                <s:password name="passwordUsuario" label="Contraseña"/>
                <s:textfield name="direccionUsuario" label="Dirección Usuario"/>
                <s:textfield name="movilUsuario" label="Teléfono móvil"/> 
                <s:submit name="modificarUsuario" value="Modificar Usuario"/>
            </s:form>
        </div>
    </div>
    <div class="miInicioSesion">
        <div class="miInicioSesion-form">
            <s:form action="iniciarSesion" method="POST">
                <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
                <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
                <s:submit cssClass="btn btn-dark" value="Volver" /> 
            </s:form>
        </div>
    </div>
    <s:include value="/comun/footer.jsp"/>

</body>
</html>
