<%-- 
    Document   : modificarAdm
    Created on : 13-jun-2022, 13:45:02
    Author     : Carlos Herrera
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
        <br>
         <h4 style="margin-left: 25px">Datos del Administrador a modificar</h4>
        
          <table class="table table-striped table-hover"  style="margin-left: 25px"> 
            <thead>
            <th>DNI</th>
            <th>Nombre</th>
            <th>Password</th>
            <th>Direccion</th>
            <th>Movil</th>
        </thead>
        <tbody>
            <tr>
                <td>
                   <s:property value="#session.adm.getDni()" />
                </td>
                <td>
                    <s:property value="#session.adm.getNombreCompleto()" />
                </td>
                <td>
                   <s:property value="#session.adm.getPassword()" />
                </td>
                <td>
                    <s:property value="#session.adm.getDireccion()" />
                </td>
                <td>
                       <s:property value="#session.adm.getMovil()" />
                </td>

            </tr>

        </tbody>
    </table>
                
        <h4 style="margin-left: 25px">Campo para modificar datos</h4>
        
        <s:form action="modificarAdm" method="post" style="margin-left: 25px">
            <s:hidden name="dniAdministrador" value="%{#session.adm.getDni()}"/>
            <s:textfield name="nombreCompleto" label="Nombre Completo"/>
            <s:password name="passwordAdministrador" label="Contraseña"/>
            <s:textfield name="direccionAdministrador" label="Dirección Administrador"/>
            <s:textfield name="movilAdministrador" label="Teléfono móvil"/> 
            <s:submit cssClass="btn btn-danger" name="modificarAdministrador" value="Modificar Administrador"/>
        </s:form>
        
        <s:form action="iniciarSesion" method="POST" style="margin-left: 25px">
             <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
             <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
             <s:submit cssClass="btn btn-dark" value="Volver" /> 
        </s:form>
        <s:include value="/comun/footer.jsp"/>
    </body>
</html>
