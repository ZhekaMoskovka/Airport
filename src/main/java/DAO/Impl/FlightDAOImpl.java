package DAO.Impl;

import DAO.FlightDAO;
import Entity.Flight;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {

    @Override
    public Flight add(Flight flight) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(flight);
        transaction.commit();
        session.close();
        return flight;
    }

    @Override
    public Flight update(Flight flight) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(flight);
        transaction.commit();
        session.close();
        return flight;
    }

    @Override
    public boolean delete(Flight flight) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(flight);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Flight get(int id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Flight flight = session.get(Flight.class, id);
        transaction.commit();
        session.close();
        return flight;
    }

    @Override
    public List<Flight> getAll() {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Flight> flightsList = session.createQuery("from flights").list();
        transaction.commit();
        session.close();
        return flightsList;
    }
}