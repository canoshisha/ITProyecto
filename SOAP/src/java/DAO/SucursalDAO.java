/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sergi
 */
public class SucursalDAO {
    
    public static List<Modelo.Sucursal> listarSucursal() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        Query q = s.createQuery("from Sucursal");
        List<Modelo.Sucursal> lista = (List<Modelo.Sucursal>) q.list();
        tx.commit();
        return lista;
        
        
    }
    
}
