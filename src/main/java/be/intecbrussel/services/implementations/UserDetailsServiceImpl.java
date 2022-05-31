package be.intecbrussel.services.implementations;

import be.intecbrussel.repository.AuteurRepository;
import be.intecbrussel.services.interfaces.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private AuteurRepository auteurRepository;

    @Autowired
    public UserDetailsServiceImpl(AuteurRepository auteurRepository){
        this.auteurRepository=auteurRepository;
    }





    }
