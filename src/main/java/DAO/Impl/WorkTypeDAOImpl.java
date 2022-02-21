package DAO.Impl;

import DAO.WorkTypeDAO;
import Entity.WorkType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class WorkTypeDAOImpl implements WorkTypeDAO {
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
    public WorkType add(WorkType workType) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(workType);
        transaction.commit();
        session.close();
        return workType;
    }

    @Override
    public WorkType update(WorkType workType) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(workType);
        transaction.commit();
        session.close();
        return workType;
    }

    @Override
    public boolean delete(WorkType workType) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(workType);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public WorkType get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        WorkType workType = session.get(WorkType.class, id);
        transaction.commit();
        session.close();
        return workType;
    }

    @Override
    public List<WorkType> getAll() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<WorkType> workTypesList = (List<WorkType>) session.createQuery("select * from work_types");
        transaction.commit();
        session.close();
        return workTypesList;
    }
}