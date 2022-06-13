/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Transferencia;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.TransferenciaREST;

/**
 *
 * @author Carlos Herrera
 */
public class eliminarTraAction extends ActionSupport {
    
    private String idTransferencia;
    
    GenericType<Transferencia> genericType = new GenericType<Transferencia>() {
    };
    GenericType<List<Transferencia>> genericTypeLista = new GenericType<List<Transferencia>>() {
    };
    
    TransferenciaREST dao = new TransferenciaREST();
    private Transferencia tra;
    ActionContext actionContext;

    private Map session;

    public String getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(String idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public Transferencia getTra() {
        return tra;
    }

    public void setTra(Transferencia tra) {
        this.tra = tra;
    }
    
    
    public eliminarTraAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String eliminarTra() throws Exception{
        dao.remove(this.getIdTransferencia());
        List<Transferencia> listaTra= (List<Transferencia>) dao.findAll_XML(genericTypeLista);

        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaTransferencia", listaTra);

        dao.close();
        return execute();
    }
}
