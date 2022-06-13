/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Administrador;
import Entidades_REST.CuentaBancaria;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.AdministradorREST;

/**
 *
 * @author mater
 */
public class eliminarAdmAction extends ActionSupport {
    
      private String dniAdministrador;
    GenericType<CuentaBancaria> genericTypeCB = new GenericType<CuentaBancaria>() {
    };
    GenericType<Administrador> genericType = new GenericType<Administrador>() {
    };
    GenericType<List<Administrador>> genericTypeLista = new GenericType<List<Administrador>>() {//
    };
 
    AdministradorREST dao = new AdministradorREST();
    
    private Administrador adm;

    ActionContext actionContext;

    private Map session;
    
    public eliminarAdmAction() {
    }

    public String getDniAdministrador() {
        return dniAdministrador;
    }

    public void setDniAdministrador(String dniAdministrador) {
        this.dniAdministrador = dniAdministrador;
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdr(Administrador adm) {
        this.adm = adm;
    }
    
    public String execute() throws Exception {
        dao.remove(this.getDniAdministrador());
        List<Administrador> listaAdm = (List<Administrador>) dao.findAll_XML(genericTypeLista);
        
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaAdministrador", listaAdm);

        dao.close();
        
        return SUCCESS;
    }
}
