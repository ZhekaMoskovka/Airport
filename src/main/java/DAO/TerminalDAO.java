package DAO;

import Entity.Terminal;

import java.util.List;

public interface TerminalDAO {
    Terminal add(Terminal terminal);
    Terminal update(Terminal terminal);
    boolean delete(Terminal terminal);
    Terminal get (int id);
    List<Terminal> getAll();
}