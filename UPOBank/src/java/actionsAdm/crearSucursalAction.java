/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Central;
import Entidades_REST.Sucursal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.CentralREST;
import wsREST.SucursalREST;

/**
 *
 * @author mater
 */
public class crearSucursalAction extends ActionSupport {
    
    String direccionSucursal,nombreCentral;
    GenericType<Sucursal> genericType = new GenericType<Sucursal>() { };
    GenericType<Central> genericTypeCL = new GenericType<Central>() { };
    GenericType<List<Sucursal>> genericTypeLista = new GenericType<List<Sucursal>>() { };
    
    SucursalREST dao = new SucursalREST();
    CentralREST daoCL = new CentralREST();
    private Sucursal suc;
    Central cl;
    
    ActionContext actionContext;
    
    private Map session;
    
    public crearSucursalAction() {
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
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
    public String insertarSucursal() throws Exception{
        Central cl = (Central) daoCL.find_XML(genericTypeCL, this.getNombreCentral());
        suc = new Sucursal();
        suc.setDireccion(this.getDireccionSucursal());
        suc.setNombreBanco(cl);
        dao.create_XML(suc);
        List<Sucursal> lisSucursal = (List<Sucursal>) dao.findAll_XML(genericTypeLista);
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaSucursal", lisSucursal);
               
        dao.close();
        return execute();
    }
    public void validate(){
        if(this.getDireccionSucursal() == null || this.getDireccionSucursal().equalsIgnoreCase("")){
            addFieldError("direccionSucursal", "El campo dirección de sucursal debe estar relleno.");
        }
    }
    
}
