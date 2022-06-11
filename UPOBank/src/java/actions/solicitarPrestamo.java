/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.Bizum;
import Entidades_REST.Prestamo;
import Entidades_REST.CuentaBancaria;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.Date;
import javax.ws.rs.core.GenericType;
import wsREST.BizumREST;
import wsREST.CuentaBancariaREST;

/**
 *
 * @author Carlos Herrera
 */
public class solicitarPrestamo {

    private String IBAN;
    private float mensualidad, cantidad;
    private Boolean hipoteca;
    private Date inicio,fin;

    GenericType<Prestamo> genericType = new GenericType<Prestamo>() {
    };
    GenericType<CuentaBancaria> genericTypeCuenta = new GenericType<CuentaBancaria>() {
    };
    BizumREST daoBizum = new BizumREST();
    CuentaBancariaREST daoCuenta = new CuentaBancariaREST();

    public solicitarPrestamo() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String nuevoPrestamo() {
        CuentaBancaria cuenta = (CuentaBancaria) daoCuenta.find_XML(genericTypeCuenta, IBAN);
        
        inicio =  new Date();
        

//        Prestamo nuevoPrestamo = new Prestamo();
//        nuevoPrestamo.setCantidad(Float.parseFloat(cantidad));
//        nuevoPrestamo.setConcepto(concepto);
//        nuevoPrestamo.setMovilDestinatario(Integer.parseInt(movilDest));
//        nuevoPrestamo.setIban(cuenta);
//        nuevoPrestamo.setFecha(date);
//
//        daoBizum.create_XML(nuevoBizum);
return SUCCESS;
    }
}
