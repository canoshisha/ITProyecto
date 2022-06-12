/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.Prestamo;
import Entidades_REST.CuentaBancaria;
import Entidades_REST.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.CuentaBancariaREST;
import wsREST.PrestamoREST;
import wsREST.UsuarioREST;

/**
 *
 * @author Carlos Herrera
 */
public class solicitarPrestamo extends ActionSupport{

    private String IBAN, cantidad;
    private Boolean hipoteca;

    GenericType<List<Prestamo>> genericTypePrestamo = new GenericType<List<Prestamo>>() {};
    GenericType<Prestamo> genericType = new GenericType<Prestamo>() {};
    GenericType<CuentaBancaria> genericTypeCuenta = new GenericType<CuentaBancaria>() {};
    GenericType<Usuario> genericTypeUsuario = new GenericType<Usuario>(){};
    UsuarioREST daoUsuario = new UsuarioREST();
    PrestamoREST daoPrestamo = new PrestamoREST();
    CuentaBancariaREST daoCuenta = new CuentaBancariaREST();
    ActionContext actionContext ;
    private Map session; 
     

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

    public Boolean getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(Boolean hipoteca) {
        this.hipoteca = hipoteca;
    }
    
    public solicitarPrestamo() {
    }

    @Override
    public void validate() {

        if (this.cantidad.isEmpty()) {
            addFieldError("cantidad", "Campo de cantidad vacia");
        }
        if (this.IBAN.isEmpty() || (CuentaBancaria) daoCuenta.find_XML(genericTypeCuenta, this.IBAN) == null) {
            addFieldError("IBAN", "IBAN registrado necesario para la operacion");
        }
        if (Float.parseFloat(this.cantidad) < 0 || Float.parseFloat(this.cantidad) >1000000) {
            addFieldError("cantidad", "Valor de cantidad no aceptado");

        }

    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String nuevoPrestamo() {
        
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        CuentaBancaria cuenta = (CuentaBancaria) daoCuenta.find_XML(genericTypeCuenta, this.IBAN);
        Usuario usuario = (Usuario) session.get("usuario");
        float saldo = cuenta.getCantidad() + Float.parseFloat(this.cantidad);
        cuenta.setCantidad(saldo);
        daoCuenta.edit_XML(cuenta, this.IBAN);
        Usuario user = (Usuario) daoUsuario.find_XML(genericTypeUsuario,usuario.getDni());
        session.put("usuario", user);
        
        Date inicio = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inicio);// Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, 1080);//Añadir 3 años en el préstamo
        Date fin = calendar.getTime();
        float mensualidad = Integer.parseInt(this.cantidad)/36;
        
        Prestamo nuevoPrestamo = new Prestamo();
        nuevoPrestamo.setIban(cuenta);
        nuevoPrestamo.setInicio(inicio);
        nuevoPrestamo.setFin(fin);
        nuevoPrestamo.setMensualidad(mensualidad);
        nuevoPrestamo.setHipoteca(this.hipoteca);
        nuevoPrestamo.setCantidad(Float.parseFloat(this.cantidad));
        
        daoPrestamo.create_XML(nuevoPrestamo);
        
         List<Prestamo> listaPrestamo = (List<Prestamo>) daoPrestamo.findAll_XML(genericTypePrestamo) ;
        
        session.put("listaPrestamo", listaPrestamo);
        return SUCCESS;
    }


}
