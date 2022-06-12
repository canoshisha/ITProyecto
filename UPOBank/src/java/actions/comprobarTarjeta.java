/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.CuentaBancaria;
import Entidades_REST.Tarjeta;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.core.GenericType;
import wsREST.CuentaBancariaREST;
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

    GenericType<Tarjeta> genericType = new GenericType<Tarjeta>() {
    };
    GenericType<CuentaBancaria> genericTypeCuenta = new GenericType<CuentaBancaria>() {
    };
    TarjetaREST daoTarjeta = new TarjetaREST();
    
    
    public comprobarTarjeta() {

    }

    public String nuevaTarjeta() {
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
