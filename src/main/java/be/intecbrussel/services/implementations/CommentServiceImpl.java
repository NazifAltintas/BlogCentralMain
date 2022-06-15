package be.intecbrussel.services.implementations;

import be.intecbrussel.data.Blog;
import be.intecbrussel.data.Comment;
import be.intecbrussel.repository.BlogsRepository;
import be.intecbrussel.repository.CommentRepository;
import be.intecbrussel.services.interfaces.BlogService;
import be.intecbrussel.services.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private BlogsRepository blogsRepository;
    private BlogService blogService;


    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, BlogsRepository blogsRepository, BlogService blogService) {
        this.commentRepository = commentRepository;
        this.blogsRepository = blogsRepository;
        this.blogService = blogService;

    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getAllCommentsByBlog(Long Id) {

        List<Comment> comment = new ArrayList<>();
        List<Comment> comments = commentRepository.findAll();


        Blog blog = blogService.getBlogById(Id);
        blog.setComments(comments);
        for (Comment comment1 : comments) {
            if (Id == comment1.getBlog().getId()) {
                comment.add(comment1);
            }

        }


        return comment;
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public void createComment(Comment comment) {
        commentRepository.save(comment);

    }


}

