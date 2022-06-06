package be.intecbrussel.services.interfaces;

import be.intecbrussel.data.Auteur;
import be.intecbrussel.data.User;
import org.dom4j.Visitor;
import java.util.List;

public interface VisitorService extends UserService{

     List<Visitor> getAllVisitors();
    Auteur getVisitorById(Long id);
    void createVisitor(Visitor visitor);
    void deleteVisitor(Visitor visitor);
}

