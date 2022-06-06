package be.intecbrussel.services.implementations;

import be.intecbrussel.data.User;

import be.intecbrussel.repository.UserRepository;
import be.intecbrussel.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserServiceImpl implements UserService {


    //You can execute SQL queries with JPA as well. EntityManager.createNativeQuery. No need to use JDBC.

    private UserRepository userRepository;

@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {

        userRepository.save(user);

    }
}
