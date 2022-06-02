package be.intecbrussel.controller;

import be.intecbrussel.Service.intefaces.BlogService;
import be.intecbrussel.data.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    @GetMapping("blog/{id}")
    public String showSingleBlog(@PathVariable String id, Model model){
        Long idInLong;
     try{
         idInLong = Long.parseLong(id);}
     catch (NumberFormatException nfe){
         System.out.println("give a proper number");
         idInLong = 1l;
     }
        Blog blog = blogService.getBlogById(idInLong);
     model.addAttribute(blog);

     return "blogPost";
    }


}
