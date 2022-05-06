package DAO.Impl;

import org.hibernate.cfg.Configuration;

//session factory for singltone
public class SessionFactory {
    private static org.hibernate.SessionFactory sessionFactory;
    public static org.hibernate.SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            return new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
}