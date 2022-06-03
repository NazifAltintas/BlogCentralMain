package be.intecbrussel.services.interfaces;

import be.intecbrussel.data.Auteur;
import be.intecbrussel.data.User;

import java.util.List;

public interface VisitorService extends UserService{

    List<User> getAllVisitors();
    Auteur getVisitorById(int id);
    void createVisitor(Auteur author);
    void deleteVisitorById(int id);
}
