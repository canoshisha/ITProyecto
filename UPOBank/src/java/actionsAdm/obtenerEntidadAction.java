/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Bizum;
import Entidades_REST.Central;
import Entidades_REST.CuentaBancaria;
import Entidades_REST.Prestamo;
import Entidades_REST.Sucursal;
import Entidades_REST.Tarjeta;
import Entidades_REST.Transferencia;
import Entidades_REST.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.BizumREST;
import wsREST.CentralREST;
import wsREST.CuentaBancariaREST;
import wsREST.PrestamoREST;
import wsREST.SucursalREST;
import wsREST.TarjetaREST;
import wsREST.TransferenciaREST;
import wsREST.UsuarioREST;

/**
 *
 * @author mater
 */
public class obtenerEntidadAction extends ActionSupport {
    
    private String dniUsuario,IBAN,numeroTarjeta,idSucursal,nombreCentral;
    
    GenericType<Usuario> genericType = new GenericType<Usuario>() {
    };
     GenericType<CuentaBancaria> genericTypeCuentaBancaria = new GenericType<CuentaBancaria>() {
    };
      GenericType<Tarjeta> genericTypeTarjeta = new GenericType<Tarjeta>() {
    };
      GenericType<Sucursal> genericTypeSucursal = new GenericType<Sucursal>() {
    };
    
    GenericType<Central> genericTypeCentral = new GenericType<Central>() {
    };
      
    Usuario usr;
    CuentaBancaria cb;
    Tarjeta tj;
    Sucursal suc;
    Central cl;
    
      
    UsuarioREST daoUsr = new UsuarioREST();
    CuentaBancariaREST daoCB = new CuentaBancariaREST();
    TarjetaREST daoTJ = new TarjetaREST();
    SucursalREST daoSuc = new SucursalREST();
    CentralREST daoCL = new CentralREST();
    
    ActionContext actionContext;

    private Map session;
    
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

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreCentral() {
        return nombreCentral;
    }

    public void setNombreCentral(String nombreCentral) {
        this.nombreCentral = nombreCentral;
    }
    
    
    
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String obtenerUsr() throws Exception{
        usr = (Usuario) daoUsr.find_XML(genericType, this.getDniUsuario());
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("usr", usr);
        return execute();
    }
    public String obtenerCuentaBancaria() throws Exception{
        cb = (CuentaBancaria) daoCB.find_XML(genericTypeCuentaBancaria, this.getIBAN());
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("cb", cb);
        return execute();
    }
    public String obtenerTarjeta() throws Exception{
        tj = (Tarjeta) daoTJ.find_XML(genericTypeTarjeta, this.getNumeroTarjeta());
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("tj", tj);
        return execute();
    }
    public String obtenerSucursal() throws Exception{
        suc = (Sucursal) daoTJ.find_XML(genericTypeSucursal, this.getIdSucursal());
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("suc", suc);
        return execute();
    }
    public String obtenerCentral() throws Exception{
        cl = (Central) daoCL.find_XML(genericTypeCentral, this.getNombreCentral());
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("cl", cl);
        return execute();
    }
    
}
