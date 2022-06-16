package be.intecbrussel.services.interfaces;


import be.intecbrussel.data.User;



import be.intecbrussel.data.Auteur;
import be.intecbrussel.data.User;


import java.util.List;

public interface UserService {






    List<User> getAllUsers();
    User getUserById(int id);
    void createUser(User user);
    void deleteUser(User user);

    User getUserByFullName(String fullName);
    User getUserEmail(String email);

}
