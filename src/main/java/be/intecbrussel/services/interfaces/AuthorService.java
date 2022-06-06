package be.intecbrussel.services.interfaces;

import be.intecbrussel.data.Auteur;
import be.intecbrussel.data.User;

import java.util.List;

public interface AuthorService {

    List<Auteur> getAllAuthors();
    Auteur getAuthorById(Long id);
    void createAuthor(Auteur author);
    void deleteAuthor(Auteur author);


    public void createUser(User user);


}

