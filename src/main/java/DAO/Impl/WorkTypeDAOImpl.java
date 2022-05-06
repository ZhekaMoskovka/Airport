package DAO.Impl;

import DAO.WorkTypeDAO;
import Entity.WorkType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class WorkTypeDAOImpl implements WorkTypeDAO {

    Session session;

    public WorkTypeDAOImpl() {
        this.session = SessionFactory.getSessionFactory().openSession();
    }

    @Override
    public WorkType add(WorkType workType) {
        Transaction transaction = session.beginTransaction();
        session.save(workType);
        transaction.commit();
        session.close();
        return workType;
    }

    @Override
    public WorkType update(WorkType workType) {
        Transaction transaction = session.beginTransaction();
        session.update(workType);
        transaction.commit();
        session.close();
        return workType;
    }

    @Override
    public boolean delete(WorkType workType) {
        Transaction transaction = session.beginTransaction();
        session.delete(workType);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public WorkType get(int id) {
        Transaction transaction = session.beginTransaction();
        WorkType workType = session.get(WorkType.class, id);
        transaction.commit();
        session.close();
        return workType;
    }

    @Override
    public List<WorkType> getAll() {
        Transaction transaction = session.beginTransaction();
        List<WorkType> workTypesList = session.createQuery("from work_types").list();
        transaction.commit();
        session.close();
        return workTypesList;
    }
}