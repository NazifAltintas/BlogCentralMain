package be.intecbrussel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BlogController {

    @GetMapping("/blog")
    public String blogExample() {
        return "blogexample";
    }

}
