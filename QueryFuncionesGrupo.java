/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate1;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class QueryFuncionesGrupo {

    public static void main(String[] args) {

        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();

        System.out.println("INICIO");//falta el numero de empleados
        Query q = sesion.createQuery("select avg(salario) from profesores");
        //Double media = (Double) q.uniqueResult();
        List<Double> lista = q.list();
        for (Double d : lista) {
             System.out.println("Salario medio: " + d);
        }

        
        
        Query q2 = sesion.createQuery("select nrp,avg(salario),count(nombre) from profesores order by nrp");
        List<Object[]> lista2 = q2.list();
        for (Object[] d : lista2) {
             System.out.println("Salario medio: " + d[0]+" Número de empleados "+d[1]);
        }
        
        
        sesion.close();

    }

}
