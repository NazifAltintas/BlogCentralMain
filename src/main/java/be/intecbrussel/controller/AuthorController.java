package be.intecbrussel.controller;

import be.intecbrussel.data.Auteur;
import be.intecbrussel.services.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@Controller
@RequestMapping("/authors")
public class AuthorController {
    private AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/registration")
    public String registerAuthor(Model model) {
        model.addAttribute("author", new Auteur());
        return "registration "; // placeholder
    }

    @PostMapping("/save")
    public String saveAuthor(@Valid @ModelAttribute("auteur") Auteur author, BindingResult result, Model model) {

        if(result.hasErrors()) {
            model.addAttribute("author", author);
            return "/";
        }
        authorService.createAuthor(author);
        return "redirect:/"; // placeholder
    }

    @GetMapping("/editRoles/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        Auteur authorToEdit = authorService.getAuthorById(id);
        List<Auteur> listOfRoles = authorService.getAllAuthors();
        model.addAttribute("authorToEdit", authorToEdit);
        model.addAttribute("rolesList", listOfRoles);
        return "redirect:/authorPage";
    }

    @PostMapping("/editRoles/save")
    public String giveRoleToAuthor(@ModelAttribute Auteur author, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("author", author);
            return "redirect:/authors/";
        }
        authorService.createAuthor(author);
        return "redirect:/authors/";
    }


    @GetMapping("/update")
    public String updateAuthorDataForm(@RequestParam Long id, Model model) {
        Auteur author = authorService.getAuthorById(id);
        System.out.println(author);
        model.addAttribute("author", author);
        return "update authorHomePage";
    }


    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Auteur id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors/";
    }


}

