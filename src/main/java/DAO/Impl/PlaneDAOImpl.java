package DAO.Impl;

import DAO.PlaneDAO;
import Entity.Plane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PlaneDAOImpl implements PlaneDAO {

    Session session;

    public PlaneDAOImpl() {
        this.session = SessionFactory.getSessionFactory().openSession();
    }


    //CRUD операции
    @Override
    public Plane add(Plane plane) {
        Transaction transaction = session.beginTransaction();
        session.save(plane);
        transaction.commit();
        session.close();
        return plane;
    }

    @Override
    public Plane update(Plane plane) {
        Transaction transaction = session.beginTransaction();
        session.update(plane);
        transaction.commit();
        session.close();
        return plane;
    }

    @Override
    public boolean delete(Plane plane) {
        Transaction transaction = session.beginTransaction();
        session.delete(plane);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Plane get(int id) {
        Transaction transaction = session.beginTransaction();
        Plane plane = session.get(Plane.class, id);
        transaction.commit();
        session.close();
        return plane;
    }

    @Override
    public List<Plane> getAll() {
        Transaction transaction = session.beginTransaction();
        List<Plane> planesList = session.createQuery("from planes").list();
        transaction.commit();
        session.close();
        return planesList;
    }
}