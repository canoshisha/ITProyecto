/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Banco.entidades.Bizum;
import Banco.entidades.Central;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author sergi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteREST.BizumREST client1=new ClienteREST.BizumREST();
        ClienteREST.CentralREST client2 = new ClienteREST.CentralREST();
        
        GenericType<List<Central>> genericType2= new GenericType<List<Central>>() {};
        
 GenericType<List<Bizum>> genericType = new GenericType<List<Bizum>>() {};
    //Returns an ArrayList of Player from the web service
    List<Bizum> data = new ArrayList<Bizum>();
    data  = (List<Bizum>) client1.findAll_XML(genericType);
    
    List<Central> data2 = new ArrayList<Central>();
    data2=(List<Central>) client2.findAll_XML(genericType2);

    System.out.println (
    "Retreiving and Displaying Player Details");
    for (Bizum players : data) {
 System.out.println("id: " + players.getId());
        System.out.println("IBAN: " + players.getIban().toString());
        System.out.println(" MovilDest: " + players.getMovilDestinatario());
    }
    
        for (Central players2 : data2) {
        System.out.println("Nombre: " + players2.getNombre());
        System.out.println("Telefono: " + players2.getTelefono());
        System.out.println(" Email: " + players2.getEmail());
    }
        
    }
    
}
