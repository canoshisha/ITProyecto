/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.Usuario;
import com.opensymphony.xwork2.ActionContext;
import wsREST.UsuarioREST;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author mater
 */
public class loginAction extends ActionSupport {

    String dniUsuario, passwordUsuario;
    GenericType<Usuario> genericType = new GenericType<Usuario>() {
    };
    UsuarioREST dao = new UsuarioREST();
    ActionContext actionContext;
    private Map session;

    public loginAction() {
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public void validate() {

        Usuario usr = (Usuario) dao.find_XML(genericType, dniUsuario);

        if (usr == null) {
            addActionError("Usuario incorrecto");
        } else if (!usr.getPassword().equalsIgnoreCase(this.getPasswordUsuario())) {
            addActionError("Contraseña incorrecta");
        }

        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("usuario", usr);

    }
    public String limpiarSession(){
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        if(session != null){
            session.clear();
        }
        
        return SUCCESS;
    }

}
