package be.intecbrussel.controller;

import be.intecbrussel.data.User;
import be.intecbrussel.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(method = RequestMethod.GET)
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService animalService) {
        this.userService = animalService;
    }


    @GetMapping("/userForm")
    public String showForm(Model model){ model.addAttribute("user", new User());

    return "registrationPage";}



    @PostMapping("/postUser")
    public String createUser(@ModelAttribute("user") User user){

        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String encoderPassword = encoder.encode(user.getPassword());
        user.setPassword(encoderPassword);
        userService.createUser(user);
        return "resgistrationSucces";
    }

    @GetMapping("/list_users")
    public String view(){
        return "users";
    }

}
