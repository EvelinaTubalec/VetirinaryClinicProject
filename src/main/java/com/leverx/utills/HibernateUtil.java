package com.leverx.utills;

import com.leverx.model.Animal;
import com.leverx.model.Note;
import com.leverx.model.Owner;
import com.leverx.model.Vet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Animal.class);
                configuration.addAnnotatedClass(Note.class);
                configuration.addAnnotatedClass(Owner.class);
                configuration.addAnnotatedClass(Vet.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return sessionFactory;
    }
}
