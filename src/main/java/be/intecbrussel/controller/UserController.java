package be.intecbrussel.controller;

import be.intecbrussel.data.*;
import be.intecbrussel.repository.UserRepository;
import be.intecbrussel.services.interfaces.BlogService;
import be.intecbrussel.services.interfaces.CommentService;
import be.intecbrussel.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(method = RequestMethod.GET)
public class UserController {

    private UserService userService;

    private CommentService commentService;

    private BlogService blogService;


    @Autowired
    private UserRepository userRepo;

    @Autowired
    public UserController(UserService userService, CommentService commentService, BlogService blogService, UserRepository userRepo) {
        this.userService = userService;
        this.commentService = commentService;
        this.blogService = blogService;
        this.userRepo = userRepo;
    }

    @GetMapping("/userForm")
    public String showForm(Model model) {

        model.addAttribute("user", new User());

        return "registrationPage";
    }


    @PostMapping("/postUser")
    public String createUser(@ModelAttribute("user") User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoderPassword = encoder.encode(user.getPassword());
        user.setPassword(encoderPassword);
        userService.createUser(user);
        return "resgistrationSucces";
    }


    @PostMapping("/postComment/{postId}")
    public String showSingleBlog(@ModelAttribute("comment") Comment comment, @PathVariable("postId") String id) {

        Long t = Long.parseLong(id);


        Blog blog = blogService.getBlogById(t);


        try {
            comment.setBlog(blog);


        } catch (NumberFormatException numberFormatException) {
            t = 1l;

            System.out.println(numberFormatException);
        }

        commentService.createComment(comment);

        return "commentSucces";
    }

    @GetMapping("user/{fullName}")
    public String showAllBlogsBS(@PathVariable String fullName,  Model model) {

        model.addAttribute("getUser",  userService.getUserByFullName(fullName));



        return "userHomePage";
    }

}
