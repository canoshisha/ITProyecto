/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Administrador;
import Entidades_REST.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.AdministradorREST;
import wsREST.UsuarioREST;

/**
 *
 * @author Carlos Herrera
 */
public class modificarAdmAction extends ActionSupport {
    private String dniAdministrador,nombreCompleto,passwordAdministrador,direccionAdministrador,movilAdministrador;
    GenericType<Administrador> genericType = new GenericType<Administrador>() { };
    GenericType<List<Administrador>> genericTypeLista = new GenericType<List<Administrador>>() { };
    
    AdministradorREST dao = new AdministradorREST();
    private Administrador adm;
    
    ActionContext actionContext;
    

    private Map session;

    public String getDniAdministrador() {
        return dniAdministrador;
    }

    public void setDniAdministrador(String dniAdministrador) {
        this.dniAdministrador = dniAdministrador;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPasswordAdministrador() {
        return passwordAdministrador;
    }

    public void setPasswordAdministrador(String passwordAdministrador) {
        this.passwordAdministrador = passwordAdministrador;
    }

    public String getDireccionAdministrador() {
        return direccionAdministrador;
    }

    public void setDireccionAdministrador(String direccionAdministrador) {
        this.direccionAdministrador = direccionAdministrador;
    }

    public String getMovilAdministrador() {
        return movilAdministrador;
    }

    public void setMovilAdministrador(String movilAdministrador) {
        this.movilAdministrador = movilAdministrador;
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }
    
    
    public modificarAdmAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String modificarAdm() throws Exception{
       
        Administrador AdministradorModificar = (Administrador) dao.find_XML(genericType, this.getDniAdministrador());
        if(this.getNombreCompleto() != null || !"".equalsIgnoreCase(this.getNombreCompleto())){
            AdministradorModificar.setNombreCompleto(this.getNombreCompleto());
        }
        if(this.getPasswordAdministrador()!= null || !"".equalsIgnoreCase(this.getPasswordAdministrador())){
            AdministradorModificar.setPassword(Integer.parseInt(this.getPasswordAdministrador()));
        }
        if(this.getDireccionAdministrador()!= null || !"".equalsIgnoreCase(this.getDireccionAdministrador())){
            AdministradorModificar.setDireccion(this.getDireccionAdministrador());
        }
        if(this.getMovilAdministrador()!= null || !"".equalsIgnoreCase(this.getMovilAdministrador())){
            AdministradorModificar.setMovil(Integer.parseInt(this.getMovilAdministrador()));
        }
         
        dao.edit_XML(AdministradorModificar, this.getDniAdministrador());
        
        List<Administrador> listaAdm = (List<Administrador>) dao.findAll_XML(genericTypeLista);
        
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaAdministrador", listaAdm);
               
        dao.close();
        
        return execute();
    }
}
