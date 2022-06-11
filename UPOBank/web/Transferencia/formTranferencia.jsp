<%-- 
    Document   : formTranferencia
    Created on : 11-jun-2022, 13:03:32
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
          <s:form>
            <s:label>IBAN destinatario </s:label> <s:text name="IBAN_dest"/>
            <s:label>Cantidad </s:label> <s:text name="cantidad"  />
            <s:label>Concepto </s:label> <s:text name="concepto"  />
            <s:hidden name="IBAN" value="AQUI VA LA VARIABLE IBAN"/>
        </s:form>
    </body>
</html>
