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
public class modificarSucursalAction extends ActionSupport {
    String direccionSucursal,idSucursal;
    GenericType<Sucursal> genericType = new GenericType<Sucursal>() { };
    GenericType<List<Sucursal>> genericTypeLista = new GenericType<List<Sucursal>>() { };
    
    SucursalREST dao = new SucursalREST();
    private Sucursal suc;
    
    ActionContext actionContext;
    
    private Map session;
    
    public modificarSucursalAction() {
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
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
    public String modificarSuc() throws Exception{
        suc = (Sucursal) dao.find_XML(genericType, this.getIdSucursal());
        if(this.getDireccionSucursal() != null && !this.getDireccionSucursal().equalsIgnoreCase("")){
            suc.setDireccion(this.getDireccionSucursal());
        }
        dao.edit_XML(suc, this.getIdSucursal());
        
        List<Sucursal> listaSuc = (List<Sucursal>) dao.findAll_XML(genericTypeLista);
        
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaSucursal", listaSuc);
               
        dao.close();
        
        
        return execute();
    }
    
}
