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

    private String nombreCentral, direccionCentral, emailCentral, telefonoCentral;

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

    public String getNombreCentral() {
        return nombreCentral;
    }

    public void setNombreCentral(String nombreCentral) {
        this.nombreCentral = nombreCentral;
    }

    public String getDireccionCentral() {
        return direccionCentral;
    }

    public void setDireccionCentral(String direccionCentral) {
        this.direccionCentral = direccionCentral;
    }

    public String getEmailCentral() {
        return emailCentral;
    }

    public void setEmailCentral(String emailCentral) {
        this.emailCentral = emailCentral;
    }

    public String getTelefonoCentral() {
        return telefonoCentral;
    }

    public void setTelefonoCentral(String telefonoCentral) {
        this.telefonoCentral = telefonoCentral;
    }

   
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String modificarCen() throws Exception {
        cl = (Central) daoCL.find_XML(genericTypeCL, this.getNombreCentral());
        if (this.getDireccionCentral()!= null && !this.getDireccionCentral().equalsIgnoreCase("")) {
            cl.setDireccion(this.getDireccionCentral());
        }
        if (this.getEmailCentral()!= null && !this.getEmailCentral().equalsIgnoreCase("")) {
            String regx = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile(regx);
            Matcher matcher = pattern.matcher(this.getEmailCentral());
            if (matcher.matches()) {
                cl.setEmail(this.getEmailCentral());
            }

        }
        if (this.getTelefonoCentral()!= null && !this.getTelefonoCentral().equalsIgnoreCase("")) {
            if(Integer.parseInt(this.getTelefonoCentral()) > 000000000 && Integer.parseInt(this.getTelefonoCentral()) < 999999999){
                cl.setTelefono(Integer.parseInt(this.getTelefonoCentral()));
            }
            
        }
        daoCL.edit_XML(cl, this.getNombreCentral());

        List<Central> listaCL = (List<Central>) daoCL.findAll_XML(genericTypeListCL);

        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaCentral", listaCL);

        daoCL.close();

        return execute();
    }

}
