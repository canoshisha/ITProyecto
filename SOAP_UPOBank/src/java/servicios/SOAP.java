
package servicios;

import POJOS_UPOBank.Usuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sergio
 */
@WebService(serviceName = "SOAP")
public class SOAP {
 /**
     * Web service operation
     * @param dni
     * @param passwd
     * @return 
     */
  @WebMethod(operationName = "usuarioLoginString")
     public String usuarioLoginString(@WebParam(name = "dni") String dni,@WebParam(name = "passwd") String passwd){
           return DAO.Usuario.UsuarioLogin(dni, passwd).toString();
    }

    /**
     * Web service operation
     * @param dni
     * @param passwd
     * @return 
     */
    @WebMethod(operationName = "loginUsuario")
    public Usuario loginUsuario(@WebParam(name = "dni") String dni, @WebParam(name = "passwd") String passwd) {
        return DAO.Usuario.UsuarioLogin(dni, passwd);
    }
    
}
