/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Bizum;
import Entidades_REST.CuentaBancaria;
import Entidades_REST.Prestamo;
import Entidades_REST.Tarjeta;
import Entidades_REST.Transferencia;
import Entidades_REST.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import wsREST.BizumREST;
import wsREST.CuentaBancariaREST;
import wsREST.PrestamoREST;
import wsREST.TarjetaREST;
import wsREST.TransferenciaREST;
import wsREST.UsuarioREST;

/**
 *
 * @author mater
 */
public class obtenerEntidadAction extends ActionSupport {
    
    private String dniUsuario,IBAN,numeroTarjeta;
    
    GenericType<Usuario> genericType = new GenericType<Usuario>() {
    };
     GenericType<CuentaBancaria> genericTypeCuentaBancaria = new GenericType<CuentaBancaria>() {
    };
      GenericType<Tarjeta> genericTypeTarjeta = new GenericType<Tarjeta>() {
    };
    
    Usuario usr;
    CuentaBancaria cb;
    Tarjeta tj;
    
      
    UsuarioREST daoUsr = new UsuarioREST();
    CuentaBancariaREST daoCB = new CuentaBancariaREST();
    TarjetaREST daoTJ = new TarjetaREST();
    
    public obtenerEntidadAction() {
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }


    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    
    
    public String execute() throws Exception {
        return execute();
    }
    
    public String obtenerUsr() throws Exception{
        usr = (Usuario) daoUsr.find_XML(genericType, this.getDniUsuario());
        
        return execute();
    }
    public String obtenerCuentaBancaria() throws Exception{
        cb = (CuentaBancaria) daoCB.find_XML(genericTypeCuentaBancaria, this.getIBAN());
        
        return execute();
    }
    public String obtenerTarjeta() throws Exception{
        tj = (Tarjeta) daoTJ.find_XML(genericTypeTarjeta, this.getNumeroTarjeta());
        
        return execute();
    }
    
}
