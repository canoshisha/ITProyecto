/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Central;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ws.rs.core.GenericType;
import wsREST.CentralREST;

/**
 *
 * @author mater
 */
public class modificarCentralAction extends ActionSupport {

    private String nombre, direccion, email, telefono;

    GenericType<Central> genericTypeCL = new GenericType<Central>() {
    };
    GenericType<List<Central>> genericTypeListCL = new GenericType<List<Central>>() {
    };
    Central cl;
    CentralREST daoCL = new CentralREST();

    ActionContext actionContext;

    private Map session;

    public modificarCentralAction() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String modificarCen() throws Exception {
        cl = (Central) daoCL.find_XML(genericTypeCL, this.getNombre());
        if (this.getDireccion() != null && !this.getDireccion().equalsIgnoreCase("")) {
            cl.setDireccion(this.getDireccion());
        }
        if (this.getEmail() != null && !this.getEmail().equalsIgnoreCase("")) {
            String regx = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile(regx);
            Matcher matcher = pattern.matcher(this.getEmail());
            if (matcher.matches()) {
                cl.setEmail(this.getEmail());
            }

        }
        if (this.getTelefono()!= null && !this.getTelefono().equalsIgnoreCase("")) {
            if(Integer.parseInt(this.getTelefono()) > 000000000 && Integer.parseInt(this.getTelefono()) < 999999999){
                cl.setTelefono(Integer.parseInt(this.getTelefono()));
            }
            
        }
        daoCL.edit_XML(cl, this.getNombre());

        List<Central> listaCL = (List<Central>) daoCL.findAll_XML(genericTypeListCL);

        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaCentral", listaCL);

        daoCL.close();

        return execute();
    }

}
