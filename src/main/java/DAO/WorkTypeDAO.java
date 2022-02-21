package DAO;

import Entity.WorkType;

import java.util.List;

public interface WorkTypeDAO {
    WorkType add(WorkType workType);
    WorkType update(WorkType workType);
    boolean delete(WorkType workType);
    WorkType get (int id);
    List<WorkType> getAll();
}