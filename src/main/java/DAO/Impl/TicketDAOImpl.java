package DAO.Impl;

import DAO.TicketDAO;
import Entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {

    Session session;

    public TicketDAOImpl() {
        this.session = SessionFactory.getSessionFactory().openSession();
    }


    //CRUD операции
    @Override
    public Ticket add(Ticket ticket) {
        Transaction transaction = session.beginTransaction();
        session.save(ticket);
        transaction.commit();
        session.close();
        return ticket;
    }

    @Override
    public Ticket update(Ticket ticket) {
        Transaction transaction = session.beginTransaction();
        session.update(ticket);
        transaction.commit();
        session.close();
        return ticket;
    }

    @Override
    public boolean delete(Ticket ticket) {
        Transaction transaction = session.beginTransaction();
        session.delete(ticket);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Ticket get(int id) {
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        transaction.commit();
        session.close();
        return ticket;
    }

    @Override
    public List<Ticket> getAll() {
        Transaction transaction = session.beginTransaction();
        List<Ticket> ticketsList = session.createQuery("from tickets").list();
        transaction.commit();
        session.close();
        return ticketsList;
    }
}