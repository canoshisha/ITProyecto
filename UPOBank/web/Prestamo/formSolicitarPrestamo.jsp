<%-- 
    Document   : fromSolicitarPrestamo
    Created on : 11-jun-2022, 13:05:24
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
        <s:form action="prestamoRegistrar" method="post">
            <s:label>Cantidad que desea </s:label> <s:text name="cantidad"/>
            <s:label>Hipoteca </s:label> <s:checkbox name="hipoteca" fieldValue="true" />
            <s:label>IBAN de la cuenta </s:label> <s:text name="IBAN"  />
            <s:hidden name="IBAN" value="AQUI VA LA VARIABLE IBAN"/>
        </s:form>
    </body>
</html>
