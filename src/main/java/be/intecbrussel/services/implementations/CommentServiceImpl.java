package be.intecbrussel.services.implementations;

import be.intecbrussel.data.Comment;
import be.intecbrussel.services.interfaces.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public Comment getCommentById() {
        return null;
    }

    @Override
    public void deleteCommentById() {

    }
}
