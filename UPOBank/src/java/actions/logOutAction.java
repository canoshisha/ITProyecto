/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.UsuarioREST;

/**
 *
 * @author alvip
 */
public class logOutAction extends ActionSupport {

    String dniUsuario, passwordUsuario;
    GenericType<Usuario> genericType = new GenericType<Usuario>() {
    };

    UsuarioREST dao = new UsuarioREST();
    private Map session;

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

    public String logOutAction() {
        ActionContext actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        if (session != null) {
            session.clear();
        }

        return SUCCESS;
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

}
