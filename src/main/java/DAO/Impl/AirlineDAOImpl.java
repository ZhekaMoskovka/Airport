package DAO.Impl;

import DAO.AirlineDAO;
import Entity.Airline;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AirlineDAOImpl implements AirlineDAO {

    @Override
    public Airline add(Airline airline) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(airline);
        transaction.commit();
        session.close();
        return airline;
    }

    @Override
    public Airline update(Airline airline) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(airline);
        transaction.commit();
        session.close();
        return airline;
    }

    @Override
    public boolean delete(Airline airline) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(airline);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Airline get(int id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Airline airline = session.get(Airline.class, id);
        transaction.commit();
        session.close();
        return airline;
    }

    @Override
    public List<Airline> getAll() {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Airline> airlinesList = session.createQuery("from airlines").list();
        transaction.commit();
        session.close();
        return airlinesList;
    }
}