package DAO.Impl;

import DAO.FlightDAO;
import Entity.Flight;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {

    Session session;
    public FlightDAOImpl() {
        this.session = SessionFactory.getSessionFactory().openSession();
    }


    //CRUD операции
    @Override
    public Flight add(Flight flight) {
        Transaction transaction = session.beginTransaction();
        session.save(flight);
        transaction.commit();
        session.close();
        return flight;
    }

    @Override
    public Flight update(Flight flight) {
        Transaction transaction = session.beginTransaction();
        session.update(flight);
        transaction.commit();
        session.close();
        return flight;
    }

    @Override
    public boolean delete(Flight flight) {
        Transaction transaction = session.beginTransaction();
        session.delete(flight);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Flight get(int id) {
        Transaction transaction = session.beginTransaction();
        Flight flight = session.get(Flight.class, id);
        transaction.commit();
        session.close();
        return flight;
    }

    @Override
    public List<Flight> getAll() {
        Transaction transaction = session.beginTransaction();
        List<Flight> flightsList = session.createQuery("from flights").list();
        transaction.commit();
        session.close();
        return flightsList;
    }
}