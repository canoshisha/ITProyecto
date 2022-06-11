/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.Sucursal;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import wsREST.SucursalREST;

/**
 *
 * @author mater
 */
public class registrarAction extends ActionSupport {
    
    private String dniUsuario,nombreCompleto,passwordUsuario,direccionUsuario,direccionSucursal,movilUsuario;
    private List<String> listaDirecciones;
    GenericType<List<Sucursal>> genericType = new GenericType<List<Sucursal>>() {
    };
    SucursalREST dao = new SucursalREST();

    public registrarAction() {
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

    public List<String> getListaDirecciones() {
        return listaDirecciones;
    }

    public void setListaDirecciones(List<String> listaDirecciones) {
        this.listaDirecciones = listaDirecciones;
    }
    
    
    
    
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    public String obtenerDireccionesSucursal(){
        this.listaDirecciones =  new ArrayList<String>();
        List <Sucursal> listaSucursales = (List<Sucursal>) dao.findAll_XML(genericType);
        for (Sucursal sucursal : listaSucursales) {
            this.listaDirecciones.add(sucursal.getDireccion());
        }
        return SUCCESS;
    }
    
}
