/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.Bizum;
import Entidades_REST.CuentaBancaria;
import Entidades_REST.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.BizumREST;
import wsREST.CuentaBancariaREST;
import wsREST.UsuarioREST;

/**
 *
 * @author sergi
 */
public class realizarBizum extends ActionSupport {
    private String movilDest,cantidad,concepto,IBAN;
    
    GenericType<List<Bizum>> genericTypeBizum = new GenericType<List<Bizum>>() {};
    GenericType<Bizum> genericType = new GenericType<Bizum>(){};
    GenericType<CuentaBancaria> genericTypeCuenta = new GenericType<CuentaBancaria>(){};
    GenericType<Usuario> genericTypeUsuario = new GenericType<Usuario>(){};
    UsuarioREST daoUsuario = new UsuarioREST();
    BizumREST daoBizum = new BizumREST();
    CuentaBancariaREST daoCuenta = new CuentaBancariaREST();
    ActionContext actionContext ;
    private Map session; 
     

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
        return SUCCESS;
    }
    public String nuevoBizum(){
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        CuentaBancaria cuenta =(CuentaBancaria) daoCuenta.find_XML(genericTypeCuenta, this.IBAN);
        Usuario usuario = (Usuario) session.get("usuario");
        float saldo = cuenta.getCantidad() - Float.parseFloat(this.cantidad);
        cuenta.setCantidad(saldo);
        daoCuenta.edit_XML(cuenta, this.IBAN);
        Usuario user = (Usuario) daoUsuario.find_XML(genericTypeUsuario,usuario.getDni());
        session.put("usuario", user);
        
        
        Date date = new Date(); 
        Bizum nuevoBizum = new Bizum();
        nuevoBizum.setCantidad(Float.parseFloat(this.cantidad));
        nuevoBizum.setConcepto(this.concepto);
        nuevoBizum.setMovilDestinatario(Integer.parseInt(this.movilDest));
        nuevoBizum.setIban(cuenta);
        nuevoBizum.setFecha(date);
        
        daoBizum.create_XML(nuevoBizum);
        
        List<Bizum> listaBizum = (List<Bizum>) daoBizum.findAll_XML(genericTypeBizum) ;
        
        session.put("listaBizum", listaBizum);
        return SUCCESS;
    }
    
}
