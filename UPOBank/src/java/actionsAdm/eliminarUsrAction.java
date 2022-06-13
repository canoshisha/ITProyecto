/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.UsuarioREST;

/**
 *
 * @author Carlos Herrera
 */
public class eliminarUsrAction {

    private String dniUsuario, nombreCompleto, passwordUsuario, direccionUsuario, direccionSucursal, movilUsuario;
    GenericType<Usuario> genericType = new GenericType<Usuario>() {
    };
    GenericType<List<Usuario>> genericTypeLista = new GenericType<List<Usuario>>() {
    };

    UsuarioREST dao = new UsuarioREST();
    private Usuario usr;

    ActionContext actionContext;

    private Map session;

    public eliminarUsrAction() {
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

    public String eliminarUsr() throws Exception {
        dao.remove(this.getDniUsuario());
        List<Usuario> listaUsr = (List<Usuario>) dao.findAll_XML(genericTypeLista);

        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaUsuarios", listaUsr);

        dao.close();
        return execute();
    }
}
