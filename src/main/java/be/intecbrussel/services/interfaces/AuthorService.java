package be.intecbrussel.services.interfaces;

import be.intecbrussel.data.Auteur;

import java.util.List;
import java.util.Optional;

public interface AuthorService extends UserService{

    List<Auteur> getAllAuthors();
    Optional<Auteur> getAuthorById(int id);
    void createAuthor(Auteur author);
    void deleteAuthor(Auteur author);

}

