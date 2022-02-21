package DAO.Impl;

import DAO.TerminalDAO;
import Entity.Terminal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class TerminalDAOImpl implements TerminalDAO {

    @Override
    public Terminal add(Terminal terminal) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(terminal);
        transaction.commit();
        session.close();
        return terminal;
    }

    @Override
    public Terminal update(Terminal terminal) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(terminal);
        transaction.commit();
        session.close();
        return terminal;
    }

    @Override
    public boolean delete(Terminal terminal) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(terminal);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Terminal get(int id) {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Terminal terminal = session.get(Terminal.class, id);
        transaction.commit();
        session.close();
        return terminal;
    }

    @Override
    public List<Terminal> getAll() {
        Session session = SessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Terminal> terminalsList = session.createQuery("from terminals").list();
        transaction.commit();
        session.close();
        return terminalsList;
    }
}