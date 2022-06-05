/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.jws.*;


/**
 *
 * @author sergi
 */
@WebService(serviceName = "SOAP")
public class SOAP {

    /**
     * This is a sample web service operation
     * @param dni
     * @param passwd
     * @return 
     */
    @WebMethod(operationName = "usuarioLogin")
    public String usuarioLogin(@WebParam(name = "dni") String dni,@WebParam(name = "passwd") String passwd){
           return DAO.Usuario.Usuario(dni, passwd).toString();
        
    }

    
}
