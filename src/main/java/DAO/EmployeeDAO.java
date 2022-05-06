package DAO;

import Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee add(Employee employee);
    Employee update(Employee employee);
    boolean delete(Employee employee);
    Employee get (int id);
    List<Employee> getAll();
}