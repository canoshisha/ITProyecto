/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosWeb;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author mater
 */
@WebService(serviceName = "ServicioWebSOAP")
public class ServicioWebSOAP {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    @WebMethod(operationName = "suma")
    public int suma(@WebParam(name = "n1") int n1,@WebParam(name = "n2") int n2) {
        return n1+n2;
    }
    
    @WebMethod(operationName = "listarSucursal")
    public String listarSucursal(){
    List<Modelo.Sucursal> lista = DAO.SucursalDAO.listarSucursal();    
    return lista.get(0).getDireccion();   
    }
    
}
