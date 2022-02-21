package DAO;

import Entity.Ticket;

import java.util.List;

public interface TicketDAO {
    Ticket add(Ticket ticket);
    Ticket update(Ticket ticket);
    boolean delete(Ticket ticket);
    Ticket get (int id);
    List<Ticket> getAll();
}