/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author sergi
 */
@Path("soapport")
public class SOAPPort {

    private servicios_client.SOAP port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SOAPPort
     */
    public SOAPPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method usuarioLoginString
     * @param dni resource URI parameter
     * @param passwd resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("usuariologinstring/")
    public String getUsuarioLoginString(@QueryParam("dni") String dni, @QueryParam("passwd") String passwd) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.usuarioLoginString(dni, passwd);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method loginUsuario
     * @param dni resource URI parameter
     * @param passwd resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<servicios_client.Usuario>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("loginusuario/")
    public JAXBElement<servicios_client.Usuario> getLoginUsuario(@QueryParam("dni") String dni, @QueryParam("passwd") String passwd) {
        try {
            // Call Web Service Operation
            if (port != null) {
                servicios_client.Usuario result = port.loginUsuario(dni, passwd);
                return new JAXBElement<servicios_client.Usuario>(new QName("http//servicios_client/", "usuario"), servicios_client.Usuario.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private servicios_client.SOAP getPort() {
        try {
            // Call Web Service Operation
            servicios_client.SOAP_Service service = new servicios_client.SOAP_Service();
            servicios_client.SOAP p = service.getSOAPPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
