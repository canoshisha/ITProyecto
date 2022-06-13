/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;


import Entidades_REST.CuentaBancaria;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.CuentaBancariaREST;

/**
 *
 * @author sergi
 */
public class modificarCB extends ActionSupport {
    private String IBANnuevo,cantidad,IBAN;
    GenericType<CuentaBancaria> genericType = new GenericType<CuentaBancaria>() { };
    GenericType<List<CuentaBancaria>> genericTypeLista = new GenericType<List<CuentaBancaria>>() { };
    CuentaBancariaREST dao = new CuentaBancariaREST();
    ActionContext actionContext;
    private Map session;
    public modificarCB() {
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getIBANnuevo() {
        return IBANnuevo;
    }

    public void setIBANnuevo(String IBANnuevo) {
        this.IBANnuevo = IBANnuevo;
    }
    
    public String execute() throws Exception {
        CuentaBancaria cuenta = (CuentaBancaria) dao.find_XML(genericType, this.IBAN);
        
        if(this.IBANnuevo!= null && !"".equalsIgnoreCase(this.IBANnuevo) ){
            cuenta.setIban(this.IBANnuevo);
        }
        if(this.cantidad!= null && !"".equalsIgnoreCase(this.cantidad) ){
            cuenta.setCantidad(Float.parseFloat(this.cantidad));
        }
        dao.edit_XML(cuenta, this.IBAN);
        
        List<CuentaBancaria> listaCB = (List<CuentaBancaria>) dao.findAll_XML(genericTypeLista);
        
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaCuentas", listaCB);
               
        dao.close();
        
        return SUCCESS;
    }
    
}
