/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios.service;

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
        resources.add(Servicios.service.BizumFacadeREST.class);
        resources.add(Servicios.service.CentralFacadeREST.class);
        resources.add(Servicios.service.CuentaBancariaFacadeREST.class);
        resources.add(Servicios.service.PrestamoFacadeREST.class);
        resources.add(Servicios.service.SucursalFacadeREST.class);
        resources.add(Servicios.service.TarjetaFacadeREST.class);
        resources.add(Servicios.service.TransferenciaFacadeREST.class);
        resources.add(Servicios.service.UsuarioFacadeREST.class);
    }
    
}
