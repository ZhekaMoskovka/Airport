package DAO.Impl;

import DAO.PlaneDAO;
import Entity.Plane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PlaneDAOImpl implements PlaneDAO {
    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            return new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
    @Override
    public Plane add(Plane plane) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(plane);
        transaction.commit();
        session.close();
        return plane;
    }

    @Override
    public Plane update(Plane plane) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(plane);
        transaction.commit();
        session.close();
        return plane;
    }

    @Override
    public boolean delete(Plane plane) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(plane);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Plane get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Plane plane = session.get(Plane.class, id);
        transaction.commit();
        session.close();
        return plane;
    }

    @Override
    public List<Plane> getAll() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Plane> planesList = (List<Plane>) session.createQuery("select * from planes");
        transaction.commit();
        session.close();
        return planesList;
    }
}