/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author victor
 */
public class QueryModif {
    
    public static void main(String[] args) {
        
        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();
        
        String hql = "update Departamentos set loc='DESPACHO2' where loc='DESPACHO3'";
        int depModificados = sesion.createQuery(hql).executeUpdate();
        System.out.println("Nº de fila afectadas: "+depModificados);
        
        String hql2 = "delete from profesores where nrp=''";
        int profModificados = sesion.createQuery(hql2).executeUpdate();
        System.out.println("Nº de fila afectadas: "+profModificados);
        
        sesion.close();
        
    }
    
}
