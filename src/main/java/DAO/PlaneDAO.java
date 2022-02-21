package DAO;

import Entity.Plane;

import java.util.List;

public interface PlaneDAO {
    Plane add(Plane plane);
    Plane update(Plane plane);
    boolean delete(Plane plane);
    Plane get (int id);
    List<Plane> getAll();
}