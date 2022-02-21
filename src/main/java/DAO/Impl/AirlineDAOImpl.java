package DAO.Impl;

import DAO.AirlineDAO;
import Entity.Airline;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AirlineDAOImpl implements AirlineDAO {
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
    public Airline add(Airline airline) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(airline);
        transaction.commit();
        session.close();
        return airline;
    }

    @Override
    public Airline update(Airline airline) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(airline);
        transaction.commit();
        session.close();
        return airline;
    }

    @Override
    public boolean delete(Airline airline) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(airline);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Airline get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Airline airline = session.get(Airline.class, id);
        transaction.commit();
        session.close();
        return airline;
    }

    @Override
    public List<Airline> getAll() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Airline> airlinesList = (List<Airline>) session.createQuery("select * from airlines");
        transaction.commit();
        session.close();
        return airlinesList;
    }
}