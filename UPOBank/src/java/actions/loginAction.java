/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.Administrador;
import Entidades_REST.Bizum;
import Entidades_REST.Central;
import Entidades_REST.CuentaBancaria;
import Entidades_REST.Prestamo;
import Entidades_REST.Sucursal;
import Entidades_REST.Tarjeta;
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
import wsREST.AdministradorREST;
import wsREST.BizumREST;
import wsREST.CentralREST;
import wsREST.CuentaBancariaREST;
import wsREST.PrestamoREST;
import wsREST.SucursalREST;
import wsREST.TarjetaREST;
import wsREST.TransferenciaREST;

/**
 *
 * @author mater
 */
public class loginAction extends ActionSupport {

    private String dniUsuario, passwordUsuario;
    GenericType<Usuario> genericType = new GenericType<Usuario>() {
    };
    GenericType<Administrador> genericTypeAdm = new GenericType<Administrador>() {
    };
    GenericType<List<Usuario>> genericTypeListUsr = new GenericType<List<Usuario>>() {
    };
    GenericType<List<Sucursal>> genericTypeListSuc = new GenericType<List<Sucursal>>() {
    };
    GenericType<List<Central>> genericTypeListCen = new GenericType<List<Central>>() {
    };
    GenericType<List<Administrador>> genericTypeListAdm = new GenericType<List<Administrador>>() {
    };
    GenericType<List<CuentaBancaria>> genericTypeListCB = new GenericType<List<CuentaBancaria>>() {
    };
    GenericType<List<Tarjeta>> genericTypeListTJ = new GenericType<List<Tarjeta>>() {
    };
    GenericType<List<Bizum>> genericTypeBizum = new GenericType<List<Bizum>>() {
    };
    GenericType<List<Transferencia>> genericTypeTranferencia = new GenericType<List<Transferencia>>() {
    };
    GenericType<List<Prestamo>> genericTypePrestamo = new GenericType<List<Prestamo>>() {
    };

    UsuarioREST dao = new UsuarioREST();
    SucursalREST daoSuc = new SucursalREST();
    CentralREST daoCen = new CentralREST();
    CuentaBancariaREST daoCB = new CuentaBancariaREST();
    AdministradorREST daoAdm = new AdministradorREST();
    TarjetaREST daoTJ = new TarjetaREST();
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
        if (this.getDniUsuario().equalsIgnoreCase("20204545K")) {
            return LOGIN;

        } else {
            return SUCCESS;
        }

    }

    public void validate() {

        Usuario usr = (Usuario) dao.find_XML(genericType, this.getDniUsuario());
        Administrador adm = (Administrador) daoAdm.find_XML(genericTypeAdm, this.getDniUsuario());
        List<Bizum> listaBizum = (List<Bizum>) daoBizum.findAll_XML(genericTypeBizum);
        List<Sucursal> listaSucursal = (List<Sucursal>) daoSuc.findAll_XML(genericTypeListSuc);
        List<Central> listaCentral = (List<Central>) daoCen.findAll_XML(genericTypeListCen);
        List<Administrador> listaAdministrador = (List<Administrador>) daoAdm.findAll_XML(genericTypeListAdm);
        List<Transferencia> listaTranferencia = (List<Transferencia>) daoTransferencia.findAll_XML(genericTypeTranferencia);
        List<Prestamo> listaPrestamo = (List<Prestamo>) daoPrestamo.findAll_XML(genericTypePrestamo);
        List<Usuario> listaUsr = (List<Usuario>) dao.findAll_XML(genericTypeListUsr);
        List<CuentaBancaria> listCuenta = (List<CuentaBancaria>) daoCB.findAll_XML(genericTypeListCB);
        List<Tarjeta> listTJ = (List<Tarjeta>) daoTJ.findAll_XML(genericTypeListTJ);

        if (usr == null && adm == null) {
            addActionError("Usuario incorrecto");
        }
        if (usr != null) {
            if (usr.getPassword()== null || !usr.getPassword().equalsIgnoreCase(this.getPasswordUsuario())) {
                addActionError("Contraseña incorrecta");
            }
        }
        if (adm != null) {
            if (String.valueOf(adm.getPassword()) == null || adm.getPassword() != Integer.parseInt(this.getPasswordUsuario())) {
                addActionError("Contraseña incorrecta");
            }
        }

        if (session != null) {
            session.clear();
        }

        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("usuario", usr);
        session.put("adm", adm);
        session.put("listaUsuarios", listaUsr);
        session.put("listaAdministrador", listaAdministrador);
        session.put("listaSucursal", listaSucursal);
        session.put("listaCentral", listaCentral);
        session.put("listaCuentas", listCuenta);
        session.put("listaBizum", listaBizum);
        session.put("listaTransferencia", listaTranferencia);
        session.put("listaPrestamo", listaPrestamo);
        session.put("listaTarjetas", listTJ);
    }

    public String limpiarSession() {
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        if (session != null) {
            session.clear();
        }

        return SUCCESS;
    }

}
