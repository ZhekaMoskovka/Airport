package DAO.Impl;

import DAO.EmployeeDAO;
import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    Session session;

    public EmployeeDAOImpl() {
        this.session = SessionFactory.getSessionFactory().openSession();
    }

    @Override
    public Employee add(Employee employee) {
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();
        return employee;
    }

    @Override
    public boolean delete(Employee employee) {
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Employee get(int id) {
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        transaction.commit();
        session.close();
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        Transaction transaction = session.beginTransaction();
        List<Employee> employeesList = session.createQuery("from employees").list();
        transaction.commit();
        session.close();
        return employeesList;
    }
}