/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS_UPOBank.HibernateUtil;
import java.util.*;
import org.hibernate.*;


public class Usuario {

    public static POJOS_UPOBank.Usuario UsuarioLogin(String dni,String passwd) {
        POJOS_UPOBank.Usuario usuario;
        Session s;
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery(" from Usuario user where user.dni = '"+dni+"' and user.password =" + passwd);
        usuario = (POJOS_UPOBank.Usuario) q.uniqueResult();
        tx.commit();
        return usuario;
    }


}
