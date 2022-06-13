/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Prestamo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.PrestamoREST;

/**
 *
 * @author Carlos Herrera
 */
public class eliminarPreAction extends ActionSupport {
    
    private String idPrestamo;
    
    GenericType<Prestamo> genericType = new GenericType<Prestamo>() {
    };
    GenericType<List<Prestamo>> genericTypeLista = new GenericType<List<Prestamo>>() {
    };
    
    PrestamoREST dao = new PrestamoREST();
    private Prestamo pre;
    ActionContext actionContext;

    private Map session;

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Prestamo getPre() {
        return pre;
    }

    public void setPre(Prestamo pre) {
        this.pre = pre;
    }

    public eliminarPreAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String eliminarPre() throws Exception{
        dao.remove(this.getIdPrestamo());
        List<Prestamo> listaPre= (List<Prestamo>) dao.findAll_XML(genericTypeLista);

        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaPrestamo", listaPre);

        dao.close();
        return execute();
    }
}
