/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.Bizum;
import Entidades_REST.CuentaBancaria;
import Entidades_REST.Prestamo;
import Entidades_REST.Transferencia;
import Entidades_REST.Usuario;
import com.opensymphony.xwork2.ActionContext;
import wsREST.UsuarioREST;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.BizumREST;
import wsREST.PrestamoREST;
import wsREST.TransferenciaREST;

/**
 *
 * @author mater
 */
public class loginAction extends ActionSupport {

    String dniUsuario, passwordUsuario;
    GenericType<Usuario> genericType = new GenericType<Usuario>() {
    };
     GenericType<List<Bizum>> genericTypeBizum = new GenericType<List<Bizum>>() {
    };
      GenericType<List<Transferencia>> genericTypeTranferencia = new GenericType<List<Transferencia>>() {
    };
      GenericType<List<Prestamo>> genericTypePrestamo = new GenericType<List<Prestamo>>() {
    };
      
    UsuarioREST dao = new UsuarioREST();
    BizumREST daoBizum = new BizumREST();
    TransferenciaREST daoTransferencia = new TransferenciaREST();
    PrestamoREST daoPrestamo = new PrestamoREST();
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
        List<Bizum> listaBizum = (List<Bizum>) daoBizum.findAll_XML(genericTypeBizum) ;
        List<Transferencia> listaTranferencia = (List<Transferencia>) daoTransferencia.findAll_XML(genericTypeTranferencia);
        List<Prestamo> listaPrestamo = (List<Prestamo>) daoPrestamo.findAll_XML(genericTypePrestamo);

        if (usr == null) {
            addActionError("Usuario incorrecto");
        } else if (!usr.getPassword().equalsIgnoreCase(this.getPasswordUsuario())) {
            addActionError("Contraseña incorrecta");
        }
        
        if(session != null){
            session.clear();
        }
         
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("usuario", usr);
        session.put("listaBizum", listaBizum);
        session.put("listaTransferencia", listaTranferencia);
        session.put("listaPrestamo", listaPrestamo);
//        List<Prestamo> listaPrestamo = new ArrayList( (usr.getIban().getPrestamoCollection()));SI uso esto peta por si alguien lo mira mañana
//        session.put("listaPrestamo", listaPrestamo);//si uso este no coge la lsta en el iterator porque es una coleccion
        

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
