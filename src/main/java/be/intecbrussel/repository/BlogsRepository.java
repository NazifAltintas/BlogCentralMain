package be.intecbrussel.repository;


import be.intecbrussel.data.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogsRepository extends JpaRepository<Blog,Long> {

}
