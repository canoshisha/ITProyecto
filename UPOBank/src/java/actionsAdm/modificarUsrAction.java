/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.UsuarioREST;

/**
 *
 * @author mater
 */
public class modificarUsrAction extends ActionSupport {
    
    private String dniUsuario,nombreCompleto,passwordUsuario,direccionUsuario,direccionSucursal,movilUsuario;
    GenericType<Usuario> genericType = new GenericType<Usuario>() { };
    GenericType<List<Usuario>> genericTypeLista = new GenericType<List<Usuario>>() { };
    
    UsuarioREST dao = new UsuarioREST();
    private Usuario usr;
    
    ActionContext actionContext;
    

    private Map session;
    
    public modificarUsrAction() {
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }

    public String getMovilUsuario() {
        return movilUsuario;
    }

    public void setMovilUsuario(String movilUsuario) {
        this.movilUsuario = movilUsuario;
    }
    
   

    public String execute() throws Exception {
        return SUCCESS;
        
        
    }
    
    public String modificarUsr() throws Exception{
       
        Usuario usuarioModificar = (Usuario) dao.find_XML(genericType, this.getDniUsuario());
        if(this.getNombreCompleto() != null || !"".equalsIgnoreCase(this.getNombreCompleto())){
            usuarioModificar.setNombreCompleto(this.getNombreCompleto());
        }
        if(this.getPasswordUsuario() != null || !"".equalsIgnoreCase(this.getPasswordUsuario())){
            usuarioModificar.setPassword(this.getPasswordUsuario());
        }
        if(this.getDireccionUsuario() != null || !"".equalsIgnoreCase(this.getDireccionUsuario())){
            usuarioModificar.setDireccion(this.getDireccionUsuario());
        }
        if(this.getMovilUsuario() != null || !"".equalsIgnoreCase(this.getMovilUsuario())){
            usuarioModificar.setMovil(Integer.parseInt(this.getMovilUsuario()));
        }
         
        dao.edit_XML(usuarioModificar, this.getDniUsuario());
        
        List<Usuario> listaUsr = (List<Usuario>) dao.findAll_XML(genericTypeLista);
        
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaUsuarios", listaUsr);
               
        dao.close();
        
        return execute();
    }
    
}
