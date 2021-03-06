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
        <title>Administracion</title>
         <s:include value="/comun/headers.jsp"/>
        <s:head/>
    </head>
    <body>
        <br>
        <h1 style="margin-left: 25px">Bienvenido <s:property value="#session.adm.getNombreCompleto()"/> </h1>
        <br>
                <h4 style="margin-left: 25px">Lista de Centrales de UPOBank</h4>
        <table  style="margin-left: 25px" class="table table-striped table-hover">  
            <thead>
                <tr>
                    <th>Nombre Banco</th>
                    <th>Direccion </th>
                    <th>Email </th>
                    <th>Teléfono Móvil </th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.listaCentral">
                    <tr>
                        <td><s:property value="getNombre()"/> </td>
                        <td><s:property value="getDireccion()"/> </td>
                        <td><s:property value="getEmail()"/> </td>
                        <td><s:property value="getTelefono()"/> </td>
                        <td>
                            <s:form action="centralModificar" method="post">
                                <s:hidden name="nombreCentral" value="%{getNombre()}"/>
                                <s:submit cssClass="btn btn-light" name="modificar" value="Modificar"/>
                            </s:form>
                            <s:form action="centralBorrar" method="post">
                                <s:hidden name="nombreCentral" value="%{getNombre()}"/>
                                <s:submit cssClass="btn btn-danger" name="borrar" value="Eliminar"/>
                            </s:form>

                        </td>
                    </tr>               
                </s:iterator>
                <s:form action="centralCrear" method="post">
                    <s:submit style="margin-left: 25px" cssClass="btn btn-dark" name="crear" value="Nueva Central"/>
                </s:form>
            </tbody>
        </table>
                <br><br>
        
        <h4 style="margin-left: 25px" >Lista de Sucursales de UPOBank</h4>
        <table  style="margin-left: 25px" class="table table-striped table-hover">  
            <thead>
                <tr>
                    <th>Nombre Banco</th>
                    <th>Direccion Sucursal</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.listaSucursal">
                    <tr>
                        <td><s:property value="getNombreBanco().getNombre()"/> </td>
                        <td><s:property value="getDireccion()"/> </td>
                        <td>
                            <s:form action="sucursalModificar" method="post">
                                <s:hidden name="idSucursal" value="%{getId()}"/>
                                <s:submit name="modificar" cssClass="btn btn-light" value="Modificar"/>
                            </s:form>

                            <s:form action="sucursalBorrar" method="post">
                                <s:hidden name="idSucursal" value="%{getId()}"/>
                                <s:submit cssClass="btn btn-danger" name="borrar" value="Eliminar"/>
                            </s:form>

                        </td>
                    </tr>               
                </s:iterator>
                <s:form action="sucursalCrear" method="post" style="margin-left: 25px">
                    <s:submit  style="margin-left: 25px" cssClass="btn btn-dark" name="crear" value="Nueva Sucursal"/>
                </s:form>
            </tbody>
        </table>
        <br><br>
        
        <h4 style="margin-left: 25px" >Lista de Administradores de UPOBank</h4>
        <table  style="margin-left: 25px" class="table table-striped table-hover">  
            <thead>
                <tr>
                    <th>DNI</th>
                    <th>Nombre Completo</th>
                    <th>Contraseña</th>
                    <th>Direccion Usuario</th>
                    <th>Teléfono Móvil</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.listaAdministrador">
                    <tr>
                        <td><s:property value="getDni()"/> </td>
                        <td><s:property value="getNombreCompleto()"/> </td>
                        <td><s:property value="getPassword()"/> </td>
                        <td><s:property value="getDireccion()"/> </td>
                        <td><s:property value="getMovil()"/></td>

                        <td>
                            <s:form action="administradorModificar" method="post">
                                <s:hidden name="dniAdministrador"  value="%{getDni()}"/>
                                <s:submit name="modificar" cssClass="btn btn-light" value="Modificar"/>
                            </s:form>

                            <s:form action="administradorBorrar" method="post">
                                <s:hidden name="dniAdministrador" value="%{getDni()}"/>
                                <s:submit cssClass="btn btn-danger" name="borrar" value="Eliminar"/>
                            </s:form>

                        </td>
                    </tr>               
                </s:iterator>
                <s:form action="administradorCrear" method="post">
                    <s:submit  style="margin-left: 25px" cssClass="btn btn-dark" name="crear" value="Nuevo administrador"/>
                </s:form>
            </tbody>
        </table>
        <br><br>
        <h4 style="margin-left: 25px" >Lista de Usuarios de UPOBank</h4>
        <table style="margin-left: 25px" class="table table-striped table-hover">  
            <thead>
                <tr>
                    <th>DNI</th>
                    <th>Nombre Completo</th>
                    <th>Contraseña</th>
                    <th>Direccion Usuario</th>
                    <th>IBAN Usuario</th>
                    <th>Direccion Sucursal</th>
                    <th>Teléfono Móvil</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.listaUsuarios">
                    <tr>
                        <td><s:property value="getDni()"/> </td>
                        <td><s:property value="getNombreCompleto()"/> </td>
                        <td><s:property value="getPassword()"/> </td>
                        <td><s:property value="getDireccion()"/> </td>
                        <td><s:property value="getIban().getIban()"/> </td>
                        <td><s:property value="getIdSucursal().getDireccion()"/> </td>
                        <td><s:property value="getMovil()"/></td>

                        <td>
                            <s:form action="usuarioModificar" method="post">
                                <s:hidden name="dniUsuario"  value="%{getDni()}"/>
                                <s:submit name="modificar" cssClass="btn btn-light" value="Modificar"/>
                            </s:form>

                            <s:form action="usuarioBorrar" method="post">
                                <s:hidden name="dniUsuario" value="%{getDni()}"/>
                                <s:submit cssClass="btn btn-danger" name="borrar" value="Eliminar"/>
                            </s:form>
                        </td>
                    </tr>               
                </s:iterator>
            </tbody>
        </table>
        <br><br>
        <h4 style="margin-left: 25px">Cuentas Bancarias de Usuarios</h4>
        <table style="margin-left: 25px" class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>IBAN Usuarios</th>
                    <th>Saldo Cuentas</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.listaCuentas">
                    <tr>
                        <td><s:property value="getIban()"/> </td>
                        <td><s:property value="getCantidad()"/>€</td>                                 
                        <td><s:form action="cuentaModificar">
                                <s:hidden name="IBAN" value="%{getIban()}"/>
                                <s:submit cssClass="btn btn-danger" cssClass="btn btn-light" value="Modificar"/>
                            </s:form>
                            </td> 
                    </tr>             
                </s:iterator>
            </tbody>
        </table>

<br><br>
        <h4 style="margin-left: 25px">Ultimos movimientos de los Usuarios</h4>
        <table style="margin-left: 25px" class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>IBAN Usuario</th>
                    <th>Fecha</th>
                    <th>Bizum/Transferencia</th>
                    <th>Concepto</th>
                    <th>Cantidad</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.listaBizum">
                    <tr>
                        <td><s:property value="getIban().getIban()"/> </td>
                        <td><s:property value="getFecha()"/> </td>
                        <td>Bizum</td>
                        <td><s:property value="getConcepto()"/></td>
                        <td><s:property value="getCantidad()"/>€</td>
                        <td>
                            <s:form action="bizumBorrar" method="post">
                                <s:hidden name="idBizum" value="%{getId()}"/>
                                <s:submit cssClass="btn btn-danger" name="borrar" value="Eliminar"/>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>

                <s:iterator value="#session.listaTransferencia">
                    <tr>
                        <td><s:property value="getIban().getIban()"/> </td>
                        <td><s:property value="getFechaInicio()"/> </td>
                        <td>Transferencia</td>
                        <td><s:property value="getConcepto()"/></td>
                        <td><s:property value="getCantidad()"/>€</td>
                        <td>
                            <s:form action="transferenciaBorrar" method="post">
                                <s:hidden name="idTransferencia" value="%{getId()}"/>
                                <s:submit cssClass="btn btn-danger" name="borrar" value="Eliminar"/>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
        <br>
        <br>
        <h4 style="margin-left: 25px">Ultimos prestamos de los Usuarios</h4>
        <table style="margin-left: 25px" class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>IBAN Usuario</th>
                    <th>Inicio</th>
                    <th>Fin</th>
                    <th>Mensualidad</th>
                    <th>¿Es hipoteca?</th>
                    <th>Cantidad</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.listaPrestamo">
                    <tr>
                        <td><s:property value="getIban().getIban()"/> </td>
                        <td><s:property value="getInicio()"/> </td>
                        <td><s:property value="getFin()"/></td>
                        <td><s:property value="getMensualidad()"/>€</td>
                        <td><s:property value="getHipoteca()"/></td>
                        <td><s:property value="getCantidad()"/>€</td>
                        <td>
                            <s:form action="prestamoBorrar" method="post">
                                <s:hidden name="idPrestamo" value="%{getId()}"/>
                                <s:submit cssClass="btn btn-danger" name="borrar" value="Eliminar"/>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
        <br></br>

        <h4 style="margin-left: 25px">Tarjetas de Usuarios</h4>
        <table style="margin-left: 25px" class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>Número de Tarjeta</th>
                    <th>Caducidad de Tarjeta</th>
                    <th>CVV</th>
                    <th>IBAN</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="#session.listaTarjetas">
                    <tr>
                        <td><s:property value="getNumerotarjeta()"/> </td>
                        <td><s:property value="getCaducidad()"/></td>
                        <td><s:property value="getCvv()"/></td>
                        <td><s:property value="getIban().getIban()"/></td>
                        <td>
                            <s:form action="tarjetaModificar" method="post">
                                <s:hidden name="numeroTarjeta" value="%{getNumerotarjeta()}"/>
                                <s:submit cssClass="btn btn-light" name="borrar" value="Modificar"/>
                            </s:form>

                            <s:form action="tarjetaBorrar" method="post">
                                <s:hidden name="numeroTarjeta" value="%{getNumerotarjeta()}"/>
                                <s:submit cssClass="btn btn-danger" name="borrar" value="Eliminar"/>
                            </s:form>
                        </td>
                    </tr>               
                </s:iterator>
            </tbody>
        </table>




        <br></br>
        <s:form action="cerrarSesion" method="POST" style="margin-left: 25px">
            <s:submit name="logOutAction" cssClass="btn btn-dark" value="Cerrar Sesión"/>
        </s:form>
        <br><br>
      <s:include value="/comun/footer.jsp"/>
    </body>
</html>
