/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.CuentaBancaria;
import Entidades_REST.Tarjeta;
import Entidades_REST.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.GenericType;
import wsREST.CuentaBancariaREST;
import wsREST.TarjetaREST;
import wsREST.UsuarioREST;

/**
 *
 * @author alvip
 */
public class comprobarTarjeta {

    String IBAN, dniUsuario;
    private Map session;
    CuentaBancariaREST daoCuenta = new CuentaBancariaREST();
    List<Tarjeta> listaTarjetas;
    ActionContext actionContext;
    GenericType<Tarjeta> genericType = new GenericType<Tarjeta>() {

    };
    GenericType<Usuario> genericTypeUser = new GenericType<Usuario>() {
    };
    GenericType<CuentaBancaria> genericTypeCuenta = new GenericType<CuentaBancaria>() {
    };
    GenericType<List<Tarjeta>> genericTypeTarjeta = new GenericType<List<Tarjeta>>() {
    };
    TarjetaREST daoTarjeta = new TarjetaREST();
    UsuarioREST daoUser = new UsuarioREST();

    public comprobarTarjeta() {

    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String execute() throws Exception {
        listaTarjetas = (List<Tarjeta>) daoTarjeta.findAll_XML(genericTypeTarjeta);
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaTarjetas", listaTarjetas);
        return SUCCESS;
    }

    public String createTarjeta() {
        listaTarjetas = (List<Tarjeta>) daoTarjeta.findAll_XML(genericTypeTarjeta);
        CuentaBancaria cuenta = (CuentaBancaria) daoCuenta.find_XML(genericTypeCuenta, this.IBAN);
        java.util.Date fecha = new Date();
        String numero_tarjeta = "";
        Date caducidad;
        int cvv = 0;
        boolean tarjetaNOk = true, primerNumero = true;
        long num_tar = 0, num_tar_ran = 0;
        int randomnum = 0;
        while (tarjetaNOk) {
            numero_tarjeta = "";
            for (int i = 0; i < 16; i++) {
                randomnum = (int) (Math.random() * 9);
                while (primerNumero) {
                    if (randomnum == 0) {
                        randomnum = (int) (Math.random() * 9);
                    } else {
                        primerNumero = false;
                    }
                }

                numero_tarjeta += randomnum;

            }
            tarjetaNOk = false;
            for (Tarjeta tarjetaAct : listaTarjetas) {
                if (tarjetaAct.getNumerotarjeta() == Long.parseLong(numero_tarjeta)) {
                    tarjetaNOk = true;
                }
            }
        }
        num_tar_ran = Long.parseLong(numero_tarjeta);
        if (num_tar < 0) {
            num_tar = num_tar_ran * (-1);
        } else {
            num_tar = num_tar_ran;
        }

        for (int i = 1; i <= 3; i++) {
            cvv += ((int) (Math.random() * 9 + 1)) * (i * 10);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);// Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, 1080);//Añadir 3 años en el préstamo
        caducidad = calendar.getTime();

        Tarjeta tarjeta = new Tarjeta(num_tar, caducidad, cvv);
        tarjeta.setIban(cuenta);

        daoTarjeta.create_XML(tarjeta);
        if (session != null) {
            session.clear();
        }

        Usuario usr = (Usuario) daoUser.find_XML(genericTypeUser, dniUsuario);
        

        listaTarjetas = (List<Tarjeta>) daoTarjeta.findAll_XML(genericTypeTarjeta);
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaTarjetas", listaTarjetas);
        session.put("usuario", usr);
        return SUCCESS;

    }

}
