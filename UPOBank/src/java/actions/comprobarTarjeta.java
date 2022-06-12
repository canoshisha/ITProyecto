/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.CuentaBancaria;
import Entidades_REST.Tarjeta;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.TarjetaREST;

/**
 *
 * @author alvip
 */
public class comprobarTarjeta {

    int Numero_tarjeta;
    Date caducidad;
    int cvv;
    String IBAN;
    private Map session; 
    List<Tarjeta> listaTarjetas;
    ActionContext actionContext ;
    GenericType<Tarjeta> genericType = new GenericType<Tarjeta>() {
    };
    GenericType<CuentaBancaria> genericTypeCuenta = new GenericType<CuentaBancaria>() {
    };
    GenericType<List<Tarjeta>> genericTypeTarjeta = new GenericType<List<Tarjeta>>() {
    };
    TarjetaREST daoTarjeta = new TarjetaREST();
    
    
    
    public comprobarTarjeta() {

    }
    public String execute() throws Exception {
        listaTarjetas =(List<Tarjeta>) daoTarjeta.findAll_XML(genericTypeTarjeta);
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaTarjetas", listaTarjetas);
        return SUCCESS;
    }
    
    public String createTarjeta() {
        java.util.Date fecha = new Date();
        Tarjeta tarjeta =(Tarjeta) daoTarjeta.findAll_XML(genericType);
        
        for (int i = 1; i <= 16; i++) {
            Numero_tarjeta = (int) (Math.random() * 9 + 1);
        }

        for (int i = 1; i <= 3; i++) {
            cvv = (int) (Math.random() * 9 + 1);
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);// Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, 1080);//Añadir 3 años en el préstamo
        caducidad = calendar.getTime();
        
        tarjeta.setNumerotarjeta(Numero_tarjeta);
        tarjeta.setCaducidad(caducidad);
        tarjeta.setCvv(cvv);
        
        daoTarjeta.create_XML(tarjeta);

        return SUCCESS;

    }


}
