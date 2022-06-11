/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author sergi
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Entidades.service.BizumFacadeREST.class);
        resources.add(Entidades.service.CentralFacadeREST.class);
        resources.add(Entidades.service.CuentaBancariaFacadeREST.class);
        resources.add(Entidades.service.PrestamoFacadeREST.class);
        resources.add(Entidades.service.SucursalFacadeREST.class);
        resources.add(Entidades.service.TarjetaFacadeREST.class);
        resources.add(Entidades.service.TransferenciaFacadeREST.class);
        resources.add(Entidades.service.UsuarioFacadeREST.class);
    }
    
}
