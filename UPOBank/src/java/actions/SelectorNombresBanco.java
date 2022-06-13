/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.Central;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import wsREST.CentralREST;

/**
 *
 * @author mater
 */
public class SelectorNombresBanco extends ActionSupport {
    
    private List<String> listaNombreCentral;
    private String nombreCentral;
    GenericType<List<Central>> genericTypeCen = new GenericType<List<Central>>() {
    };
    CentralREST daoSuc = new CentralREST();
    
    public SelectorNombresBanco() {
    }

    public List<String> getListaNombreCentral() {
        return listaNombreCentral;
    }

    public void setListaNombreCentral(List<String> listaNombreCentral) {
        this.listaNombreCentral = listaNombreCentral;
    }

    public String getNombreCentral() {
        return nombreCentral;
    }

    public void setNombreCentral(String nombreCentral) {
        this.nombreCentral = nombreCentral;
    }
    
    
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String obtenerDireccionesSucursal() throws Exception{
        this.listaNombreCentral =  new ArrayList<String>();
        List <Central> listaCentral = (List<Central>) daoSuc.findAll_XML(genericTypeCen);
        for (Central central : listaCentral) {
            this.listaNombreCentral.add(central.getNombre());
        }
        daoSuc.close();
        return execute();
    }
    
}
