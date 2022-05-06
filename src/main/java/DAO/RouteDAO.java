package DAO;

import Entity.Route;

import java.util.List;

public interface RouteDAO {
    Route add(Route route);
    Route update(Route route);
    boolean delete(Route route);
    Route get (int id);
    List<Route> getAll();
}