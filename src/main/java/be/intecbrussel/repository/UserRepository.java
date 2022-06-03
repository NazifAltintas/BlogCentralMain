package be.intecbrussel.repository;

import be.intecbrussel.data.Comment;
import be.intecbrussel.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}