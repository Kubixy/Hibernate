package hibernate1;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MasAntiguo {

    public static void main(String[] args) {

        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();
        Query a = sesion.createQuery("from profesores p order by p.fecha_alta asc");
        a.setMaxResults(1);

        List<Profesores> lista = a.list();
        int msg = 0;

        for (Profesores p : lista) {
            msg = p.getDepartamentos().getDeptNo();
        }

        Query b = sesion.createQuery("from profesores p where p.departamentos.deptNo = ?");
        b.setInteger(0, msg);
        List<Profesores> lista2 = b.list();
        for (Profesores p : lista2) {
            System.out.println(p.getNombre()+" "+p.getApellidos()+" "+p.getDepartamentos().getDeptNo()+" "+p.getDepartamentos().getDnombre());
        }
    
    }

}
