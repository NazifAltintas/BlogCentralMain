package be.intecbrussel.repository;


import be.intecbrussel.data.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogsRepository extends JpaRepository<Blog,Long> {

}
