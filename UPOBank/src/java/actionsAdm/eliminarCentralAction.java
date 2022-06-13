/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Central;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.CentralREST;

/**
 *
 * @author mater
 */
public class eliminarCentralAction extends ActionSupport {
    String nombreCentral;
    GenericType<List<Central>> genericTypeListCL = new GenericType<List<Central>>() {
    };
    CentralREST daoCL = new CentralREST();

    ActionContext actionContext;

    private Map session;
    public eliminarCentralAction() {
    }

    public String getNombreCentral() {
        return nombreCentral;
    }

    public void setNombreCentral(String nombreCentral) {
        this.nombreCentral = nombreCentral;
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    public String eliminarCentral() throws Exception{
        
        daoCL.remove(this.getNombreCentral());
        List<Central> listaCL = (List<Central>) daoCL.findAll_XML(genericTypeListCL);
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaCentral", listaCL);
        
        daoCL.close();
        
        return execute();
    }
}
