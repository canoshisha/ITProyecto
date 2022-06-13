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
public class crearCentralAction extends ActionSupport {

    private String nombreCentral, direccionCentral, emailCentral, telefonoCentral;

    GenericType<Central> genericTypeCL = new GenericType<Central>() {
    };
    GenericType<List<Central>> genericTypeListCL = new GenericType<List<Central>>() {
    };
    Central cl;
    CentralREST daoCL = new CentralREST();

    ActionContext actionContext;

    private Map session;

    public crearCentralAction() {
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

    public String insertarCentral() throws Exception {
        Central cl = new Central(this.getNombreCentral(), this.getDireccionCentral(), this.getEmailCentral(), Integer.parseInt(this.getTelefonoCentral()));
        daoCL.create_XML(cl);
        List<Central> listCL = (List<Central>) daoCL.findAll_XML(genericTypeCL);
        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaCentral", listCL);

        return execute();
    }

    public void validate() {
        if (this.getNombreCentral() == null || this.getNombreCentral().equalsIgnoreCase("")) {
            addFieldError("nombreCentral", "El campo nombre de la central no puede estar vacío.");
        }

        if (this.getDireccionCentral() == null || this.getDireccionCentral().equalsIgnoreCase("")) {
            addFieldError("direccionCentral", "El campo direccion de la central no puede estar vacío.");
        }
        if (this.getEmailCentral() == null || this.getEmailCentral().equalsIgnoreCase("")) {
            addFieldError("emailCentral", "El campo email de la central no puede estar vacío.");

        } else {
            
            String regx = "^[A-Za-z0-9+_.-]+@(.+)$";

            Pattern pattern = Pattern.compile(regx);
            Matcher matcher = pattern.matcher(this.getEmailCentral());
            if (!matcher.matches()) {
               addFieldError("emailCentral", "El campo email debe tener el formato correcto.");
            }
        }
        if (this.getTelefonoCentral() == null || this.getTelefonoCentral().equalsIgnoreCase("")) {
            addFieldError("telefonoCentral", "El campo telefono de la central no puede estar vacío.");
            

        }else{
            if (Integer.parseInt(this.getTelefonoCentral()) < 000000000 || Integer.parseInt(this.getTelefonoCentral()) > 999999999) {
                addFieldError("telefonoCentral", "El campo telefono de la central debe tener ser de 9 dígitos.");
            }
        }
    }

}
