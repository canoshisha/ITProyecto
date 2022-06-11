/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.Bizum;
import Entidades_REST.CuentaBancaria;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import javax.ws.rs.core.GenericType;
import wsREST.BizumREST;
import wsREST.CuentaBancariaREST;

/**
 *
 * @author sergi
 */
public class realizarBizum extends ActionSupport {
    private String movilDest,cantidad,concepto,IBAN;
    
    GenericType<Bizum> genericType = new GenericType<Bizum>(){};
    GenericType<CuentaBancaria> genericTypeCuenta = new GenericType<CuentaBancaria>(){};
    BizumREST daoBizum = new BizumREST();
    CuentaBancariaREST daoCuenta = new CuentaBancariaREST();

    public realizarBizum() {
    }
    
    @Override
    public void validate() {

        

     if (Integer.parseInt(movilDest) <9 || Integer.parseInt(movilDest) > 9) {
            addFieldError("El telefono debe tener 9 digitos");
     }
     if(cantidad.isEmpty()){
            addFieldError("Campo de cantidad vacia");
        }
     if(concepto.isEmpty()){
         addFieldError("Campo de cantidad vacia");
     }
     if(Float.parseFloat(cantidad) <0){
         addFieldError("Valor de cantidad no aceptado");

     }
     
    }
    
    @Override
    public String execute() throws Exception {
        CuentaBancaria cuenta =(CuentaBancaria) daoCuenta.find_XML(genericTypeCuenta, IBAN);
        float saldo = cuenta.getCantidad() - Float.parseFloat(cantidad);
        cuenta.setCantidad(saldo);
        daoCuenta.edit_XML(cuenta, IBAN);
        
        Date date = new Date(); 
        
        Bizum nuevoBizum = new Bizum();
        nuevoBizum.setCantidad(Float.parseFloat(cantidad));
        nuevoBizum.setConcepto(concepto);
        nuevoBizum.setMovilDestinatario(Integer.parseInt(movilDest));
        nuevoBizum.setIban(cuenta);
        nuevoBizum.setFecha(date);
        
        daoBizum.create_XML(nuevoBizum);
        return SUCCESS;
    }
    
}
