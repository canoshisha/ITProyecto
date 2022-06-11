/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.CuentaBancaria;
import Entidades_REST.Transferencia;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.core.GenericType;
import wsREST.CuentaBancariaREST;
import wsREST.TransferenciaREST;

/**
 *
 * @author sergi
 */
public class realizarTransferencia extends ActionSupport {

    private String IBAN_dest, cantidad, concepto, IBAN;

    GenericType<Transferencia> genericType = new GenericType<Transferencia>() {
    };
    GenericType<CuentaBancaria> genericTypeCuenta = new GenericType<CuentaBancaria>() {
    };
    TransferenciaREST daoTransf = new TransferenciaREST();
    CuentaBancariaREST daoCuenta = new CuentaBancariaREST();

    public realizarTransferencia() {
    }

    public String getIBAN_dest() {
        return IBAN_dest;
    }

    public void setIBAN_dest(String IBAN_dest) {
        this.IBAN_dest = IBAN_dest;
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
     if(this.IBAN_dest.isEmpty()){
             addFieldError("IBAN_dest","Campo de IBAN destinatario vacia");
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
    
    
    public String execute() throws Exception {
        CuentaBancaria cuenta = (CuentaBancaria) daoCuenta.find_XML(genericTypeCuenta, this.IBAN);
        float saldo = cuenta.getCantidad() - Float.parseFloat(this.cantidad);
        cuenta.setCantidad(saldo);
        daoCuenta.edit_XML(cuenta, this.IBAN);
        
        
        
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);// Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, 3);// numero de díasaañadir,orestar en caso de días<0
        
        Transferencia nuevaTransferencia = new Transferencia();
        nuevaTransferencia.setCantidad(Float.parseFloat(this.cantidad));
        nuevaTransferencia.setConcepto(this.concepto);
        nuevaTransferencia.setIBANdestinatario(this.IBAN_dest);
        nuevaTransferencia.setIban(cuenta);
        nuevaTransferencia.setFechaInicio(date);
        nuevaTransferencia.setFechaFin(calendar.getTime());
        
        daoTransf.create_XML(nuevaTransferencia);
        
        

        return SUCCESS;
    }

}
