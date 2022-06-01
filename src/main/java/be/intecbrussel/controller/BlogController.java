package be.intecbrussel.controller;

import be.intecbrussel.data.Auteur;
import be.intecbrussel.data.Blog;
import be.intecbrussel.service.intefaces.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    private BlogService blogService;

    public BlogController() {
    }

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog")
    public String blogExample() {
        return "blogexample";
    }

    @GetMapping("/blogs")
    public String showAllBlogs(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "blogPage";

    }

    @GetMapping("/blogsBS")
    public String showAllBlogsBS(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "index";

    }






}
