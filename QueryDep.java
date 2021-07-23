package hibernate1;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

public class QueryDep {

    public static void main(String[] args) {

        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();

        Query q = sesion.createQuery("from Departamentos");
//        List<Departamentos> lista = q.list();
//        for (Departamentos dep : lista) {
//            System.out.println(dep.getDeptNo() + " + " + dep.getDnombre());
//        }

        q.setFetchSize(5);
        Iterator iter = q.iterate();
        Departamentos depi;
        while (iter.hasNext()) {
            depi = (Departamentos) iter.next();
            System.out.println(depi.getDeptNo() + " + " + depi.getDnombre());
        }
//
//        Query a = sesion.createQuery("from Departamentos where dnombre='informatica'");
//        List<Departamentos> list = a.list();
//        for (Departamentos dep : list) {
//            System.out.println(dep.getDeptNo() + " + " + dep.getDnombre());
//        }
        sesion.close();
    }
    

}
