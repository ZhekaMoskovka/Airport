package DAO.Impl;

import DAO.RouteDAO;
import Entity.Route;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class RouteDAOImpl implements RouteDAO {

    Session session;

    public RouteDAOImpl() {
        this.session = SessionFactory.getSessionFactory().openSession();
    }

    @Override
    public Route add(Route route) {
        Transaction transaction = session.beginTransaction();
        session.save(route);
        transaction.commit();
        session.close();
        return route;
    }

    @Override
    public Route update(Route route) {
        Transaction transaction = session.beginTransaction();
        session.update(route);
        transaction.commit();
        session.close();
        return route;
    }

    @Override
    public boolean delete(Route route) {
        Transaction transaction = session.beginTransaction();
        session.delete(route);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Route get(int id) {
        Transaction transaction = session.beginTransaction();
        Route route = session.get(Route.class, id);
        transaction.commit();
        session.close();
        return route;
    }

    @Override
    public List<Route> getAll() {
        Transaction transaction = session.beginTransaction();
        List<Route> routesList = session.createQuery("from routes").list();
        transaction.commit();
        session.close();
        return routesList;
    }
}