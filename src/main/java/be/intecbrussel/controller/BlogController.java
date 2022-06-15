package be.intecbrussel.controller;


import be.intecbrussel.data.Blog;
import be.intecbrussel.data.Search;
import be.intecbrussel.services.interfaces.BlogService;
import be.intecbrussel.services.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class BlogController {

    private BlogService blogService;

    private CommentService commentService;

    public BlogController() {
    }

    @Autowired
    public BlogController(BlogService blogService, CommentService commentService) {
        this.blogService = blogService;
        this.commentService = commentService;
    }

    @GetMapping("/blogs")
    public String showAllBlogs(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        model.addAttribute("search", new Search());

        return "blogPage";

    }

   @GetMapping("/blogsBS")
    public String showAllBlogsBS(Model model) {
        List<Blog> allBlogs = blogService.getAllBlogs();

        double pageSize = Math.ceil(allBlogs.size() / 6.0);
        model.addAttribute("blogs", allBlogs.subList(0, 6));

        model.addAttribute("allBlogs", allBlogs.size());
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("search", new Search());
        return "index";
    }

    @GetMapping("blog/{id}")
    public String showBlogs(@PathVariable String id, Model model) {
        Long idInLong;
        try {
            idInLong = Long.parseLong(id);
        } catch (NumberFormatException nfe) {
            System.out.println("give a proper number");
            idInLong = 1l;
        }
        model.addAttribute("allOfComments", commentService.getAllComments());
        Blog blog = blogService.getBlogById(idInLong);
        model.addAttribute(blog);
        model.addAttribute("search", new Search());

        return "blogPost";
    }

    @PostMapping("/blog")
    public String searchByTitle(@ModelAttribute("search") Search search,
                                Model model) {
        List<Blog> blogs = blogService.findBlogsByTitle(search.getTitle());
        double pageSize = Math.ceil(blogs.size() / 6.0);

        model.addAttribute("blogs", blogs);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("search", new Search());

        return "index";
    }

    //GetMapping("allBlogs/{authorName}")
    public String searchByAuthorName(@ModelAttribute String Name, Model model) {
        model.addAttribute("search", new Search());
        return "blogPage";
    }

    @GetMapping("/newBlogs")
    public String sortByDate(Model model) {
        model.addAttribute("search", new Search());

        List<Blog> blogs = blogService.sortByDate();
        Collections.reverse(blogs);

        model.addAttribute("blogs", blogs);
        return "index";
    }

    @GetMapping("/oldBlogs")
    public String sortByOldDate(Model model) {
        model.addAttribute("search", new Search());

        List<Blog> blogs = blogService.sortByDate();
        model.addAttribute("blogs", blogs);
        return "index";
    }

    @GetMapping("blogpage/{num}")
    public String showBlogsByPageNum(@PathVariable String num, Model model) {
        List<Blog> allBlogs = blogService.getAllBlogs();

        double pageSize = Math.ceil(allBlogs.size() / 6.0);

        int idInInt;
        try {
            idInInt = Integer.parseInt(num);
        } catch (NumberFormatException nfe) {
            System.out.println("give a proper number");
            idInInt = 1;
        }
        List<Blog> blogs = blogService.getBlogByPageNum(idInInt);
         model.addAttribute("blogs",blogs);
        model.addAttribute("search", new Search());
        model.addAttribute("pageSize",pageSize);

 return "index";
    }
}