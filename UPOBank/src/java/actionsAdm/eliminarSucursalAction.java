/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Sucursal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.SucursalREST;

/**
 *
 * @author mater
 */
public class eliminarSucursalAction extends ActionSupport {
    String idSucursal;
    GenericType<List<Sucursal>> genericTypeLista = new GenericType<List<Sucursal>>() { };
    
    SucursalREST dao = new SucursalREST();
    
    ActionContext actionContext;
    
    private Map session;
    public eliminarSucursalAction() {
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    public String eliminarSucursal() throws Exception{
        dao.remove(this.getIdSucursal());
        List<Sucursal> listaSuc = (List<Sucursal>) dao.findAll_XML(genericTypeLista);
        
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaSucursal", listaSuc);
               
        dao.close();
        return execute();
    }
    
}
