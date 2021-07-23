package hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;

public class QueryParam {

    public static void main(String[] args) {

        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();

        Query a = sesion.createQuery("from Profesores p where p.departamentos=:dnep and p.salario>:sal");
        a.setString("dnep", "10");
        a.setInteger("sal", 2000);
        List<Profesores> lista = a.list();
        for (Profesores p : lista) {
            System.out.println(p.getNombre()+" "+p.getApellidos()+" "+p.getSalario());
        }

        
     

        sesion.close();
    }

}
