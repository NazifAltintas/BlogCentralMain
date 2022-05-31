package be.intecbrussel.services.interfaces;

import be.intecbrussel.data.Auteur;
import be.intecbrussel.data.Commentator;

import java.util.List;

public interface VisitorService extends UserService{

    List<Commentator> getAllVisitors();
    Auteur getVisitorById(int id);
    void createVisitor(Auteur author);
    void deleteVisitorById(int id);
}
