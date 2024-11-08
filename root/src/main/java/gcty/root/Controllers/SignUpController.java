package gcty.root.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gcty.root.Entities.User;
import gcty.root.Services.UserService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping
    public String submitSignUpForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user-form";
        } else {
            userService.saveUser(user);
            return "redirect:/index";
        }
    }

}