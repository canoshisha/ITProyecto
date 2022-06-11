/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import Entidades_REST.CuentaBancaria;
import Entidades_REST.Sucursal;
import Entidades_REST.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.GenericType;
import wsREST.CuentaBancariaREST;
import wsREST.SucursalREST;
import wsREST.UsuarioREST;

/**
 *
 * @author mater
 */
public class registrarAction extends ActionSupport {
    
    private String dniUsuario,nombreCompleto,passwordUsuario,direccionUsuario,direccionSucursal,movilUsuario;
    private List<String> listaDirecciones;
    GenericType<List<Sucursal>> genericTypeSuc = new GenericType<List<Sucursal>>() {
    };
    GenericType<List<CuentaBancaria>> genericTypeCB = new GenericType<List<CuentaBancaria>>() {
    };
    GenericType<List<Usuario>> genericTypeUsr = new GenericType<List<Usuario>>() {
    };
    SucursalREST daoSuc = new SucursalREST();
    UsuarioREST daoUsr = new UsuarioREST();
    CuentaBancariaREST daoCB = new CuentaBancariaREST();
            

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
        List <Sucursal> listaSucursales = (List<Sucursal>) daoSuc.findAll_XML(genericTypeSuc);
        for (Sucursal sucursal : listaSucursales) {
            this.listaDirecciones.add(sucursal.getDireccion());
        }
        daoSuc.close();
        return SUCCESS;
    }
    
    public String registrarUsuario() throws Exception{
        Usuario usr = new Usuario();
        usr.setDni(this.getDniUsuario());
        usr.setNombreCompleto(this.getNombreCompleto());
        usr.setDireccion(this.getDireccionUsuario());
        
        List <Sucursal> listaSucursales = (List<Sucursal>) daoSuc.findAll_XML(genericTypeSuc);
        for (Sucursal sucursal : listaSucursales) {
            if(sucursal.getDireccion().equalsIgnoreCase(this.getDireccionSucursal())){
                Sucursal sl = sucursal;
            }
        }
        boolean correcto;
        do {          
            correcto = false;
            String iban = "ES"+GenerarIBAN();
            
            List<CuentaBancaria> listaCuentas = (List<CuentaBancaria>) daoCB.findAll_XML(genericTypeCB);
            for (CuentaBancaria cuenta : listaCuentas) {
                if(cuenta.getIban().equalsIgnoreCase(iban)){
                    correcto = true;
                }
            }
                     
        } while (correcto == true);
        
        
        
        
        
        
        return execute();
        
    }
    public String GenerarIBAN() {
        Random random = new Random();
        String cadena = "";
        for (int i = 0; i < 22; i++) {
           cadena += String.valueOf(random.nextInt(10));
        }
          ;
        return cadena;
    }
    
}
