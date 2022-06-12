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

    public String getMovilDest() {
        return movilDest;
    }

    public void setMovilDest(String movilDest) {
        this.movilDest = movilDest;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
    
    @Override
    public void validate() {

     if (this.movilDest.length()!= 9) {
            addFieldError("movilDest","El telefono debe tener 9 digitos");
     }
     if(this.cantidad.isEmpty()){
            addFieldError("cantidad","Campo de cantidad vacia");
        }
     if(this.concepto.isEmpty()){
         addFieldError("concepto","Campo de cantidad vacia");
     }
     if(Float.parseFloat(this.cantidad) <0){
         addFieldError("cantidad","Valor de cantidad no aceptado");

     }
     
    }
    
    @Override
    public String execute() throws Exception {
        CuentaBancaria cuenta =(CuentaBancaria) daoCuenta.find_XML(genericTypeCuenta, this.IBAN);
        float saldo = cuenta.getCantidad() - Float.parseFloat(this.cantidad);
        cuenta.setCantidad(saldo);
        daoCuenta.edit_XML(cuenta, this.IBAN);
        
        Date date = new Date(); 
        
        Bizum nuevoBizum = new Bizum();
        nuevoBizum.setCantidad(Float.parseFloat(this.cantidad));
        nuevoBizum.setConcepto(this.concepto);
        nuevoBizum.setMovilDestinatario(Integer.parseInt(this.movilDest));
        nuevoBizum.setIban(cuenta);
        nuevoBizum.setFecha(date);
        
        daoBizum.create_XML(nuevoBizum);
        
        
        return SUCCESS;
    }
    
}
