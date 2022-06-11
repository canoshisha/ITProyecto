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
    
     @Override
    public void validate() {
     if(IBAN_dest.isEmpty()){
             addFieldError("IBAN_dest","Campo de IBAN destinatario vacia");
        }
     if(cantidad.isEmpty()){
           addFieldError("cantidad","Campo de cantidad vacia");
        }
     if(concepto.isEmpty()){
         addFieldError("concepto","Campo de cantidad vacia");
     }
     if(Float.parseFloat(cantidad) <0){
         addFieldError("cantidad","Valor de cantidad no aceptado");

     }
     
    }
    
    
    public String execute() throws Exception {
        CuentaBancaria cuenta = (CuentaBancaria) daoCuenta.find_XML(genericTypeCuenta, IBAN);
        float saldo = cuenta.getCantidad() - Float.parseFloat(cantidad);
        cuenta.setCantidad(saldo);
        daoCuenta.edit_XML(cuenta, IBAN);
        
        
        
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);// Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, 3);// numero de díasaañadir,orestar en caso de días<0
        
        Transferencia nuevaTransferencia = new Transferencia();
        nuevaTransferencia.setCantidad(Float.parseFloat(cantidad));
        nuevaTransferencia.setConcepto(concepto);
        nuevaTransferencia.setIBANdestinatario(IBAN_dest);
        nuevaTransferencia.setIban(cuenta);
        nuevaTransferencia.setFechaInicio(date);
        nuevaTransferencia.setFechaFin(calendar.getTime());
        
        daoTransf.create_XML(nuevaTransferencia);
        
        

        return SUCCESS;
    }

}
