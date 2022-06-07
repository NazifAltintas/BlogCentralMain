package be.intecbrussel.controller;


import be.intecbrussel.data.Blog;
import be.intecbrussel.data.Search;
import be.intecbrussel.services.interfaces.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {

    private BlogService blogService;

    public BlogController() {
    }

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    @GetMapping("/blogs")
    public String showAllBlogs(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "blogPage";

    }

    @GetMapping("/blogsBS")
    public String showAllBlogsBS(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        model.addAttribute("search",new Search());
        return "index";
    }

    @GetMapping("blog/{id}")
    public String showSingleBlog(@PathVariable String id, Model model) {
        Long idInLong;
        try {
            idInLong = Long.parseLong(id);
        } catch (NumberFormatException nfe) {
            System.out.println("give a proper number");
            idInLong = 1l;
        }
        Blog blog = blogService.getBlogById(idInLong);
        model.addAttribute(blog);

        return "blogPost";
    }

    @PostMapping("/blog")
    public String searchByTitle(@ModelAttribute("search") Search search,
                                Model model) {
        List<Blog> blogs = blogService.findBlogsByTitle(search.getTitle());
        model.addAttribute("blogs",blogs);
        return "index";
    }
    //GetMapping("allBlogs/{authorName}")
    public String searchByAuthorName(@ModelAttribute String Name, Model model){
        return "blogPage";
    }

}
