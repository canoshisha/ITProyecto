/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sergi
 */
@WebService(serviceName = "SOAP")
public class SOAP {
    
@WebMethod(operationName = "usuarioLoginString")
     public String usuarioLoginString(@WebParam(name = "dni") String dni,@WebParam(name = "passwd") String passwd){
           return DAO.Usuario.UsuarioLogin(dni, passwd).getDni();
    }
}
