/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Banco.entidades.Bizum;
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
        ClienteREST.JerseyClient client1=new ClienteREST.JerseyClient();
 GenericType<List<Bizum>> genericType = new GenericType<List<Bizum>>() {
    };
    //Returns an ArrayList of Player from the web service
    List<Bizum> data = new ArrayList<Bizum>();
    data  = (List<Bizum>) client1.findAll_XML(genericType);

    System.out.println (
    "Retreiving and Displaying Player Details");
    for (Bizum players : data

    
        ) {
 System.out.println("id: " + players.getId());
        System.out.println("IBAN: " + players.getIban().toString());
        System.out.println(" MovilDest: " + players.getMovilDestinatario());
    }
    }
    
}
