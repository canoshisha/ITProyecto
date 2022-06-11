/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Banco.entidades.Usuario;
import wsREST.UsuarioREST;
import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author mater
 */
public class loginAction extends ActionSupport {
    
    String dniUsuario,passwordUsuario;
    GenericType<Usuario> genericType = new GenericType<Usuario>(){};
    UsuarioREST dao = new UsuarioREST();
    
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
        
    }
    
    public void validate(){
        
        Usuario usr;
        
		if("mkyong".equals(getUsername())){
			
		
			addActionError("I don't know you, dont try to hack me!");
		}
	}
    
}
