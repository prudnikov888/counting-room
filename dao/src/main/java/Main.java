import org.hibernate.SessionFactory;
import utils.HibernateUtil;

/**
 * Created by anpr0915 on 25.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println(sessionFactory);
    }
}
