<%-- 
    Document   : formBizum
    Created on : 11-jun-2022, 13:00:22
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
        <s:form action="" method="POST">
            <s:label>Movil destinatario </s:label> <s:textfield name="movilDest"/>
            <s:label>Cantidad </s:label> <s:textfield name="cantidad"  />
            <s:label>Concepto </s:label> <s:textfield name="concepto"  />
            <s:hidden name="IBAN" value="AQUI VA LA VARIABLE IBAN"/>
        </s:form>
    </body>
</html>
