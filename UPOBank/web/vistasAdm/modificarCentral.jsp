<%-- 
    Document   : modificarCentral
    Created on : 13-jun-2022, 11:46:27
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
        <br>
         <h4  style="margin-left: 25px">Datos de la Central a modificar </h4>
         
         <table class="table table-striped table-hover"  style="margin-left: 25px"> 
            <thead>
            <th>Nombre</th>
            <th>Direccion</th>
            <th>Email</th>
            <th>Telefono</th>
        </thead>
        <tbody>
            <tr>
                <td>
                    <s:property value="#session.cl.getNombre()" />
                </td>
                <td>
                     <s:property value="#session.cl.getDireccion()" />
                </td>
                <td>
                     <s:property value="#session.cl.getEmail()" />
                </td>
                <td>
                    <s:property value="#session.cl.getTelefono()" />
                </td>

            </tr>

        </tbody>
    </table>
        
        <h4  style="margin-left: 25px">Campo para modificar datos</h4>
        
        <s:form action="modificarCentral" method="post" style="margin-left: 25px">
            <s:hidden name="nombreCentral" value="%{#session.cl.getNombre()}"/>
            <s:textfield name="direccionCentral" label="Dirección de la Central"/>
            <s:textfield name="emailCentral" label="Email de la Central"/>
            <s:textfield name="telefonoCentral" label="Teléfono de la Central"/> 
            <s:submit cssClass="btn btn-danger" name="modificarCentral" value="Modificar Central"/>
        </s:form>
        
        <s:form action="iniciarSesion" method="POST"  style="margin-left: 25px">
             <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
             <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
             <s:submit cssClass="btn btn-dark" value="Volver" /> 
        </s:form>
        <s:include value="/comun/footer.jsp"/>
    </body>
</html>
