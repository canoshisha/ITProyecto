/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Administrador;
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
public class crearAdmAction extends ActionSupport {
    private String dniAdm,nombreCompleto,passwordAdm,direccionAdm,movilAdm;
    GenericType<Administrador> genericTypeAdm = new GenericType<Administrador>() {
    };
    GenericType<List<Administrador>> genericTypeListAdm = new GenericType<List<Administrador>>() {
    };
    
    AdministradorREST daoAdm = new AdministradorREST();
    
    ActionContext actionContext;

    private Map session;
    
    public crearAdmAction() {
    }

    public String getDniAdm() {
        return dniAdm;
    }

    public void setDniAdm(String dniAdm) {
        this.dniAdm = dniAdm;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPasswordAdm() {
        return passwordAdm;
    }

    public void setPasswordAdm(String passwordAdm) {
        this.passwordAdm = passwordAdm;
    }

    public String getDireccionAdm() {
        return direccionAdm;
    }

    public void setDireccionAdm(String direccionAdm) {
        this.direccionAdm = direccionAdm;
    }

    public String getMovilAdm() {
        return movilAdm;
    }

    public void setMovilAdm(String movilAdm) {
        this.movilAdm = movilAdm;
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String insertarAdm() throws Exception{
        Administrador adm = new Administrador(this.getDniAdm(), this.getNombreCompleto(), Integer.parseInt(this.getPasswordAdm()), this.getDireccionAdm(), Integer.parseInt(this.getMovilAdm()));
        daoAdm.create_XML(adm);
        
        List<Administrador> listAdm = (List<Administrador>) daoAdm.findAll_XML(genericTypeListAdm);
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaAdministrador", listAdm);
        daoAdm.close();
        return execute();
    }
    public void validate(){
        if (this.getDniAdm()== null || "".equals(this.getDniAdm())) {
            addFieldError("dniAdm","El campo dni debe estar relleno");
        } else if (!this.getDniAdm().matches("(\\d{8})([-]?)([A-Z]{1})")) {
            addFieldError("dniUsuario","Formato de DNI incorrecto, debe tener 8 números y una letra.");
        }
        if (this.getNombreCompleto() == null || "".equals(this.getNombreCompleto())) {
            addFieldError("nombreCompleto","El campo nombre completo debe estar relleno.");
        }
        if(this.getPasswordAdm()== null || "".equals(this.getPasswordAdm())){
            addFieldError("passwordAdm","El campo contraseña debe estar relleno.");
        }else if(this.getPasswordAdm().length() < 5){           
            addFieldError("passwordAdm","La contraseña debe tener una longitud mínima de 5 caracteres.");
        }
        if(this.getDireccionAdm()== null || "".equals(this.getDireccionAdm())){
            addFieldError("direccionUsuario","El campo direccion Usuario debe estar relleno.");
        }
        if(this.getMovilAdm()== null || "".equals(this.getMovilAdm())){
            addFieldError("movilUsuario","El campo telefóno móvil debe estar relleno.");
        }else if(this.getMovilAdm().length() != 9){
            addFieldError("movilUsuario","El telefóno móvil debe tener entre 9 dígitos.");
        }
        Administrador adm = (Administrador) daoAdm.find_XML(genericTypeAdm, this.getDniAdm());
        if(adm != null){
            addActionError("El administrador ya existe");
        }
    }
    
}
