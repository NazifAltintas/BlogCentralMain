package be.intecbrussel.repository;

import be.intecbrussel.data.Blog;
import be.intecbrussel.data.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
