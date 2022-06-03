package be.intecbrussel.services.implementations;

import be.intecbrussel.data.Auteur;
import be.intecbrussel.data.User;
import be.intecbrussel.services.interfaces.VisitorService;

import java.util.List;

public class VisitorServiceImpl implements VisitorService {
    @Override
    public List<User> getAllVisitors() {
        return null;
    }

    @Override
    public Auteur getVisitorById(int id) {
        return null;
    }

    @Override
    public void createVisitor(Auteur author) {

    }

    @Override
    public void deleteVisitorById(int id) {

    }
}
