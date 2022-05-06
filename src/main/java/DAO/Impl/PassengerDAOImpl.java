package DAO.Impl;

import DAO.PassengerDAO;
import Entity.Passenger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class PassengerDAOImpl implements PassengerDAO {

    Session session;

    public PassengerDAOImpl() {
        this.session = SessionFactory.getSessionFactory().openSession();
    }

    @Override
    public Passenger add(Passenger passenger) {
        Transaction transaction = session.beginTransaction();
        session.save(passenger);
        transaction.commit();
        session.close();
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        Transaction transaction = session.beginTransaction();
        session.update(passenger);
        transaction.commit();
        session.close();
        return passenger;
    }

    @Override
    public boolean delete(Passenger passenger) {
        Transaction transaction = session.beginTransaction();
        session.delete(passenger);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Passenger get(int id) {
        Transaction transaction = session.beginTransaction();
        Passenger passenger = session.get(Passenger.class, id);
        transaction.commit();
        session.close();
        return passenger;
    }

    @Override
    public List<Passenger> getAll() {
        Transaction transaction = session.beginTransaction();
        List<Passenger> passengersList = session.createQuery("from passengers").list();
        transaction.commit();
        session.close();
        return passengersList;
    }
//!!!
    public List<Passenger> getAllWithTickets() {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select id, name, ticket.id from passengers p "
                + "left join fetch tickets as t "
                + "on p.id = t.passenger_id");
        List<Passenger> passengersList = query.getResultList();
        transaction.commit();
        session.close();
        return passengersList;
    }
}