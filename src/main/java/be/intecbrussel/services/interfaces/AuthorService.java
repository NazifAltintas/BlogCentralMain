package be.intecbrussel.services.interfaces;

import be.intecbrussel.data.Auteur;

import java.util.List;

public interface AuthorService {

    List<Auteur> getAllAuthors();
    Auteur getAuthorById(Long id);
    void createAuthor(Auteur author);
    void deleteAuthor(Auteur author);

}

