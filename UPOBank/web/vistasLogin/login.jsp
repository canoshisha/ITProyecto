<%-- 
    Document   : login
    Created on : 11-jun-2022, 10:52:18
    Author     : mater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UPOBank</title>
        <s:include value="/comun/headers.jsp"/>
    </head>
    <body>
        <div class="login">
            <div class="container">
                <div class="login-modal">
                    <s:if test="hasActionErrors()">
                        <div class="errors">
                            <s:actionerror/>
                        </div>
                    </s:if>
                    <br><br>
                    <h1>Bienvenido a UPOBANK</h1>
                    <br>
                    <s:form action="iniciarSesion" method="post">
                        <s:textfield name="dniUsuario" label="DNI"/>
                        <s:password name="passwordUsuario" label="Contraseña"/>
                        <s:submit cssClass="btn btn-danger" name="iniciarSesion" value="Iniciar Sesión"/>
                    </s:form>
                    <p>¿Aún no te has registrado?</p>
                    <s:form action="regi" method="post">
                        <s:submit cssClass="btn btn-dark" name="registrar" value="Registrarse"/>            
                    </s:form>
                </div>
            </div>
            <s:include value="/comun/footer_login.jsp"/>
        </div>
    </body>
</html>
