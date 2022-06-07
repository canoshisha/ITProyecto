/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.HibernateUtil;
import org.hibernate.*;


public class Usuario {

    public static POJOS.Usuario UsuarioLogin(String dni,String passwd) {
        POJOS.Usuario usuario;
        Session s;
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery(" from Usuario user where user.dni = '"+dni+"' and user.password =" + passwd);
        usuario = (POJOS.Usuario) q.uniqueResult();
        tx.commit();
        return usuario;
    }


}
