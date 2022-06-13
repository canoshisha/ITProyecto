/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Tarjeta;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.TarjetaREST;

/**
 *
 * @author alvip
 */
public class eliminarTarjetaAction {

    private String numeroTarjeta;

    GenericType<List<Tarjeta>> genericTypeLista = new GenericType<List<Tarjeta>>() {
    };

    TarjetaREST dao = new TarjetaREST();
    private Tarjeta tarjeta;
    ActionContext actionContext;

    private Map session;

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public eliminarTarjetaAction() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }
    
     public String eliminarTarjeta() throws Exception{
        dao.remove(this.getNumeroTarjeta());
        List<Tarjeta> listaTarjetas= (List<Tarjeta>) dao.findAll_XML(genericTypeLista);

        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaTarjetas", listaTarjetas);

        dao.close();
        return execute();
    }

}
