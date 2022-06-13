/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Bizum;
import Entidades_REST.CuentaBancaria;
import Entidades_REST.Prestamo;
import Entidades_REST.Tarjeta;
import Entidades_REST.Transferencia;
import Entidades_REST.Usuario;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.BizumREST;
import wsREST.CuentaBancariaREST;
import wsREST.PrestamoREST;
import wsREST.TarjetaREST;
import wsREST.TransferenciaREST;
import wsREST.UsuarioREST;

/**
 *
 * @author Carlos Herrera
 */
public class eliminarUsrAction extends ActionSupport {

    private String dniUsuario;
    GenericType<CuentaBancaria> genericTypeCB = new GenericType<CuentaBancaria>() {
    };
    GenericType<Usuario> genericType = new GenericType<Usuario>() {
    };
    GenericType<List<Usuario>> genericTypeLista = new GenericType<List<Usuario>>() {//
    };
     GenericType<List<CuentaBancaria>> genericTypeListaCB = new GenericType<List<CuentaBancaria>>() {//
    };
    GenericType<List<Prestamo>> genericTypeListaPres = new GenericType<List<Prestamo>>() {//
    };
    GenericType<List<Transferencia>> genericTypeListaTrans = new GenericType<List<Transferencia>>() {//
    };
    GenericType<List<Bizum>> genericTypeListaBizum = new GenericType<List<Bizum>>() {//
    };
    GenericType<List<Tarjeta>> genericTypeListaTarjeta = new GenericType<List<Tarjeta>>() {//
    };
 
    UsuarioREST dao = new UsuarioREST();
    CuentaBancariaREST daoCB = new CuentaBancariaREST();
    PrestamoREST daoPrestamo = new PrestamoREST();
    TransferenciaREST daoTransferencia = new TransferenciaREST();
    BizumREST daoBizum = new BizumREST();
    TarjetaREST daoTarjeta = new TarjetaREST();
    
    
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

  


    public String execute() throws Exception {
        eliminarTarjeta();
        eliminarPre();
        eliminarBizum();
        eliminarTrans();
        eliminarCB();
        eliminarUsr();
        return SUCCESS;

    }

    public void eliminarUsr() throws Exception {
        dao.remove(this.getDniUsuario());
        List<Usuario> listaUsr = (List<Usuario>) dao.findAll_XML(genericTypeLista);
        
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaUsuarios", listaUsr);

        dao.close();
    }
    
    public void eliminarCB() throws Exception{
        usr =(Usuario) dao.find_XML(genericType, this.getDniUsuario());
        daoCB.remove( usr.getIban().getIban());
        List<CuentaBancaria> listaCB = (List<CuentaBancaria>) daoCB.findAll_XML(genericTypeListaCB);
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaCuentas", listaCB);

        daoCB.close();
    }
    public void eliminarPre() throws Exception{
        List<Prestamo> listaPres =(List<Prestamo>) daoPrestamo.findAll_XML(genericTypeListaPres);
         usr = dao.find_XML(genericType, this.getDniUsuario());
         for (Prestamo prestamo : listaPres) {
             if(prestamo.getIban().getIban().equalsIgnoreCase(usr.getIban().getIban())){
                 daoPrestamo.remove(String.valueOf(prestamo.getId()));
             }
         }
         listaPres = (List<Prestamo>) daoPrestamo.findAll_XML(genericTypeListaPres);
         actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaPrestamo", listaPres);

        daoPrestamo.close();
    }
    public void eliminarTrans() throws Exception{
        List<Transferencia> listaTrans =(List<Transferencia>) daoTransferencia.findAll_XML(genericTypeListaTrans);
        
         usr =(Usuario) dao.find_XML(genericType, this.getDniUsuario());
         for (Transferencia trans : listaTrans) {
             if(trans.getIban().getIban().equalsIgnoreCase(usr.getIban().getIban())){
                 daoTransferencia.remove(String.valueOf(trans.getId()));
             }
         }
        listaTrans =(List<Transferencia>) daoTransferencia.findAll_XML(genericTypeListaTrans);
         actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaTransferencia", listaTrans);

        daoTransferencia.close();
    }
    public void eliminarBizum() throws Exception{
        List<Bizum> listaBizum =(List<Bizum>) daoBizum.findAll_XML(genericTypeListaBizum);
        
         usr =(Usuario) dao.find_XML(genericType, this.getDniUsuario());
         for (Bizum biz : listaBizum) {
             if(biz.getIban().getIban().equalsIgnoreCase(usr.getIban().getIban())){
                 daoBizum.remove(String.valueOf(biz.getId()));
             }
         }
        listaBizum =(List<Bizum>) daoBizum.findAll_XML(genericTypeListaBizum);
         actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaBizum", listaBizum);

        daoBizum.close();
    }
    
     public void eliminarTarjeta() throws Exception{
        List<Tarjeta> listaTarjetas=(List<Tarjeta>) daoTarjeta.findAll_XML(genericTypeListaTarjeta);
        
         usr =(Usuario) dao.find_XML(genericType, this.getDniUsuario());
         for (Tarjeta tar : listaTarjetas) {
             if(tar.getIban().getIban().equalsIgnoreCase(usr.getIban().getIban())){
                 daoTarjeta.remove(tar.getNumerotarjeta()+"");
             }
         }
        listaTarjetas= (List<Tarjeta>) daoTarjeta.findAll_XML(genericTypeListaTarjeta);
         actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaTarjetas", listaTarjetas);

        daoTarjeta.close();
    }
    
}
