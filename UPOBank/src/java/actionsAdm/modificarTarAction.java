/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Tarjeta;
import Entidades_REST.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.TarjetaREST;
import wsREST.UsuarioREST;

/**
 *
 * @author Carlos Herrera
 */
public class modificarTarAction extends ActionSupport {

    private String numeroTarjeta, cvv, caducidadTarjeta;
    GenericType<Tarjeta> genericType = new GenericType<Tarjeta>() {
    };
    GenericType<List<Tarjeta>> genericTypeLista = new GenericType<List<Tarjeta>>() {
    };

    TarjetaREST dao = new TarjetaREST();
    private Tarjeta tj;

    ActionContext actionContext;

    private Map session;

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCaducidadTarjeta() {
        return caducidadTarjeta;
    }

    public void setCaducidadTarjeta(String caducidadTarjeta) {
        this.caducidadTarjeta = caducidadTarjeta;
    }

    public Tarjeta getTar() {
        return tj;
    }

    public void setTar(Tarjeta tj) {
        this.tj = tj;
    }

    public modificarTarAction() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String modificarTar() throws Exception {

        Tarjeta tarjetaModificar = (Tarjeta) dao.find_XML(genericType, this.getNumeroTarjeta());
        tarjetaModificar.setCvv(Integer.parseInt(this.getCvv()));
        dao.edit_XML(tarjetaModificar,this.numeroTarjeta);

        List<Tarjeta> listaTar = (List<Tarjeta>) dao.findAll_XML(genericTypeLista);

        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaTarjetas", listaTar);

        dao.close();

        return execute();
    }
}
