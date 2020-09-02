package local.nix.programming.courses.hibernate.util;

import local.nix.programming.courses.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(Grade.class);
                configuration.addAnnotatedClass(Group.class);
                configuration.addAnnotatedClass(Lesson.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(Topic.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("HibernateSessionFactoryUtilException:" + e);
            }
        }
        return sessionFactory;
    }
}
