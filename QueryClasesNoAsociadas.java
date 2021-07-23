/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate1;

import hibernate1.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

public class QueryClasesNoAsociadas {

    public static void main(String[] args) {
        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();

//        System.out.println("INICIO");
//        Query q = sesion.createQuery("from Departamentos d, Profesores e " + "where d.deptNo=e.departamentos.deptNo order by e.apellido");
//        List<Object[]> lista = q.list();
//        Departamentos dep;


        System.out.println("INICIO");
        Query q = sesion.createQuery("from Departamentos d, Profesores e " + "where d.deptNo=e.departamentos.deptNo order by e.apellido");
        q.setFetchSize(5);
        Iterator iter = q.iterate();
        Departamentos dep;
        Profesores prof;

        while (iter.hasNext()) {
            Object[] a = (Object[]) iter.next();
            Departamentos d = (Departamentos) a[0];
            Profesores p = (Profesores) a[1];
            System.out.println(d.getDeptNo() + " * " + d.getDnombre() + " * " + p.getApellido());

        }

        System.out.println("FIN");
        sesion.close();
    }
}
