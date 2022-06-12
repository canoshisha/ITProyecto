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
public class SelectorDireccionesAction extends ActionSupport {
    
    private List<String> listaDirecciones;
    private String direccionSucursal;
    GenericType<List<Sucursal>> genericTypeSuc = new GenericType<List<Sucursal>>() {
    };
    SucursalREST daoSuc = new SucursalREST();
    
    public SelectorDireccionesAction() {
    }

    public List<String> getListaDirecciones() {
        return listaDirecciones;
    }

    public void setListaDirecciones(List<String> listaDirecciones) {
        this.listaDirecciones = listaDirecciones;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String obtenerDireccionesSucursal() throws Exception{
        this.listaDirecciones =  new ArrayList<String>();
        List <Sucursal> listaSucursales = (List<Sucursal>) daoSuc.findAll_XML(genericTypeSuc);
        for (Sucursal sucursal : listaSucursales) {
            this.listaDirecciones.add(sucursal.getDireccion());
        }
        daoSuc.close();
        return execute();
    }
    
}
