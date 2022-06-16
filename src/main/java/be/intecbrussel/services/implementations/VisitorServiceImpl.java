package be.intecbrussel.services.implementations;

import be.intecbrussel.data.Auteur;
import be.intecbrussel.data.User;
import be.intecbrussel.services.interfaces.VisitorService;
import org.dom4j.Visitor;

import java.util.List;

public class VisitorServiceImpl implements VisitorService {





    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User getUserByFullName(String fullName) {
        return null;
    }

    @Override
    public User getUserEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }



    @Override
    public User getUserById(int id) {
        return null;
    }



    @Override
    public List<Visitor> getAllVisitors() {
        return null;
    }

    @Override
    public Auteur getVisitorById(Long id) {
        return null;
    }

    @Override
    public void createVisitor(Visitor visitor) {

    }

    @Override
    public void deleteVisitor(Visitor visitor) {

    }
}
