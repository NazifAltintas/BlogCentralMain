package be.intecbrussel.services.implementations;


import be.intecbrussel.data.Auteur;
import be.intecbrussel.repository.AuteurRepository;
import be.intecbrussel.services.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AuthorServiceImpl implements AuthorService {

    private AuteurRepository auteurRepository;

    @Autowired
    public AuthorServiceImpl(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    @Override
    public List<Auteur> getAllAuthors() {
        return auteurRepository.findAll();
    }

    @Override
    public Auteur getAuthorById(Long id) {
        return auteurRepository.findById(id).get();
    }

    @Override
    public void createAuthor(Auteur author) {
        auteurRepository.save(author);
    }

    @Override
    public void deleteAuthor(Auteur author) {
        auteurRepository.delete(author);

    }
}
