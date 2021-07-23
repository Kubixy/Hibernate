package hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InsertaNuevos {

    public static void main(String[] args) {

        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();

        String hql = "insert into NuevosDep('70','GESTION EMPRESARIAL','DESPA15')";
        int num = sesion.createQuery(hql).executeUpdate();

        System.out.println("Nº de filas insertadas: " + num);

    }

}
