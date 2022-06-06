package be.intecbrussel.services.interfaces;

import be.intecbrussel.data.Comment;
import java.util.List;

public interface CommentService {


    List<Comment> getAllComments();
    Comment getCommentById(Long Id);
    void deleteComment(Comment comment);
    void createComment(Comment comment);

}
