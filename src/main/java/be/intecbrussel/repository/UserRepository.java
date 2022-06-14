package be.intecbrussel.repository;


import be.intecbrussel.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    public User findByUserName(String userName);

//    @Query("SELECT u FROM User u WHERE u.id = ?1")
//    public User findById(Integer userName);
}

