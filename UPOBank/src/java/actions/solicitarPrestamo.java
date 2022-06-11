/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.Prestamo;
import Entidades_REST.CuentaBancaria;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.core.GenericType;
import wsREST.CuentaBancariaREST;
import wsREST.PrestamoREST;

/**
 *
 * @author Carlos Herrera
 */
public class solicitarPrestamo extends ActionSupport{

    private String IBAN, cantidad;
    private Boolean hipoteca;

    GenericType<Prestamo> genericType = new GenericType<Prestamo>() {
    };
    GenericType<CuentaBancaria> genericTypeCuenta = new GenericType<CuentaBancaria>() {
    };
    PrestamoREST daoPrestamo = new PrestamoREST();
    CuentaBancariaREST daoCuenta = new CuentaBancariaREST();

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

    public solicitarPrestamo() {
    }

    @Override
    public void validate() {

        if (this.cantidad.isEmpty()) {
            addFieldError("cantidad", "Campo de cantidad vacia");
        }
//        if (this.IBAN.isEmpty() || (CuentaBancaria) daoCuenta.find_XML(genericTypeCuenta, this.IBAN) == null) {
//            addFieldError("IBAN", "IBAN registrado necesario para la operacion");
//        }
        if (Float.parseFloat(this.cantidad) < 0 || Float.parseFloat(this.cantidad) >1000000) {
            addFieldError("cantidad", "Valor de cantidad no aceptado");

        }

    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String nuevoPrestamo() {
        
        CuentaBancaria cuenta = (CuentaBancaria) daoCuenta.find_XML(genericTypeCuenta, this.IBAN);
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
        return SUCCESS;
    }


}
