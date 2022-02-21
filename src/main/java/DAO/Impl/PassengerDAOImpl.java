package DAO.Impl;

import DAO.PassengerDAO;
import Entity.Passenger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PassengerDAOImpl implements PassengerDAO {

    @Override
    public Passenger add(Passenger passenger) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(passenger);
        transaction.commit();
        session.close();
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(passenger);
        transaction.commit();
        session.close();
        return passenger;
    }

    @Override
    public boolean delete(Passenger passenger) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(passenger);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Passenger get(int id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Passenger passenger = session.get(Passenger.class, id);
        transaction.commit();
        session.close();
        return passenger;
    }

    @Override
    public List<Passenger> getAll() {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Passenger> passengersList = session.createQuery("from passengers").list();
        transaction.commit();
        session.close();
        return passengersList;
    }
}