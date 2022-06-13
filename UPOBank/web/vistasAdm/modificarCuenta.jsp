<%-- 
    Document   : modificarCuenta
    Created on : 12-jun-2022, 19:01:28
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
        <h4 style="margin-left: 25px">Datos de la cuenta a modificar</h4>
         <table style="margin-left: 25px" class="table table-striped table-hover"> 
              <thead>
              <th>IBAN</th>
              <th>Cantidad de la cuenta</th>
              </thead>
              <tbody>
                  <tr>
                      <td>
                           <s:property value="#session.cb.getIban()" />
                      </td>
                      <td>
                          <s:property value="#session.cb.getCantidad()" />
                      </td>
                  </tr>
              </tbody>
         </table>
        <h4 style="margin-left: 25px">Campo para modificar datos</h4>
        <div class="miCuenta">
            <div class="miCuenta-form">
                <s:form action="modificarCB" method="post" style="margin-left: 25px">
                    <s:textfield name="IBANnuevo" label="IBAN de la cuenta"/>
                    <s:textfield name="cantidad" label="Cantidad"/>
                    <s:hidden name="IBAN" value="%{#session.cb.getIban()}"/>
                    <s:submit cssClass="btn btn-danger"  name="modificarCantidad" value="Modificar Cantidad"/>
                </s:form>
            </div>
        </div>
        <br>

        <s:form action="iniciarSesion" method="POST" style="margin-left: 25px">
            <s:hidden name="dniUsuario" value="%{#session.adm.getDni()}"/>
            <s:hidden name="passwordUsuario" value="%{#session.adm.getPassword()}"/>
            <s:submit style="margin-left: 25px" cssClass="btn btn-dark" value="Volver" /> 
        </s:form>
        <br><br>
        <s:include value="/comun/footer.jsp"/>
    </body>
</html>
