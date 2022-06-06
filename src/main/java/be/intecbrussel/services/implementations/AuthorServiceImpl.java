package be.intecbrussel.services.implementations;

import be.intecbrussel.data.Auteur;
import be.intecbrussel.data.User;
import be.intecbrussel.repository.AuteurRepository;
import be.intecbrussel.services.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuteurRepository auteurRepository;

    @Autowired
    public AuthorServiceImpl(AuteurRepository auteurRepository){
        this.auteurRepository=auteurRepository;
    }


    @Override
    public List<Auteur> getAllAuthors() {
        return auteurRepository.findAll();
    }

    @Override
    public Optional<Auteur> getAuthorById(int id) {
        return auteurRepository.findById(id);
    }

    @Override
    public void createAuthor(Auteur author) {
        auteurRepository.save(author);

    }

    @Override
    public void deleteAuthor(Auteur author) {
        auteurRepository.delete(author);

    }

    @Override
    public void createUser(User user) {

    }
}
